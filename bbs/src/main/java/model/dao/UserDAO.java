package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.UserVO;

public class UserDAO {
	public boolean createUser(UserVO vo) {
		boolean result = false;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn.prepareStatement(
				"INSERT INTO user (name, email, pw, phone, register_date, last_date) VALUES (?, ?, ?, ?, now(), null)")) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPw());
			pstmt.setString(4, vo.getPhone());
			pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.err.println("계정 생성 오류 : " + e.getMessage());
		}
		MySQL.close(conn);
		return result;
	}

	public List<UserVO> readAllUsers() {
		Connection conn = MySQL.connect();
		List<UserVO> uList = null;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT uid, name, email, phone, register_date, last_date FROM user");
			uList = new ArrayList<UserVO>();
			UserVO user;
			while (rs.next()) {
				user = new UserVO();
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRegister_date(rs.getString("register_date"));
				user.setLast_date(rs.getString("last_date"));
				uList.add(user);
			}
		} catch (Exception e) {
			System.err.println("전체 계정 조회 오류 : " + e.getMessage());
		}
		MySQL.close(conn);
		return uList;
	}

	public UserVO readOneUser(String email, String pw) {
		Connection conn = MySQL.connect();
		UserVO user = null;
		try (PreparedStatement pstmt = conn.prepareStatement(
				"SELECT uid, name, email, pw, phone, register_date, last_date FROM user WHERE email=?");
				Statement stmt = conn.createStatement()) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() && pw.equals(rs.getString("pw"))) {
				user = new UserVO(rs);
				System.out.println("로그인 성공!");
				stmt.executeUpdate("UPDATE user SET last_date=now() WHERE uid=" + user.getUid());
			} else {
				System.out.println("계정정보를 확인하세요.");
			}
		} catch (Exception e) {
			System.err.println(email + " 계정 조회 오류" + e.getMessage());
		}
		MySQL.close(conn);
		return user;
	}

	public UserVO readOneUser(int uid) {
		Connection conn = MySQL.connect();
		UserVO user = null;
		try (PreparedStatement pstmt = conn.prepareStatement(
				"SELECT uid, name, email, pw, phone, register_date, last_date FROM user WHERE uid=?")) {
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserVO(rs);
				System.out.println(user.getName() + " 조회 성공!");
			} else {
				System.out.println("계정정보를 확인하세요.");
			}
		} catch (Exception e) {
			System.err.println(uid + " 계정 조회 오류" + e.getMessage());
		}
		MySQL.close(conn);
		return user;
	}

	public boolean updateUser(UserVO vo) {
		boolean result = false;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn
				.prepareStatement("UPDATE user SET pw=?, phone=?, last_date=NOW() WHERE uid=?")) {
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getPhone());
			pstmt.setInt(3, vo.getUid());
			pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.err.println(vo.getName() + " 계정 수정 오류" + e.getMessage());
		}
		MySQL.close(conn);
		return result;
	}

}
