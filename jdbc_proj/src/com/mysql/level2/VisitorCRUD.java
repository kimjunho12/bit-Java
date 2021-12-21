package com.mysql.level2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitorCRUD {				// DAO : Data Access Object
	public boolean c(Scanner scan) {
		boolean result = false;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into visitor (name, writedate, memo) values (?, now(), ?)")) {
			while (true) {
				System.out.print("작성자 이름을 입력하세요 : ");
				String name = scan.nextLine();
				System.out.print("글의 내용을 입력하세요 : ");
				String memo = scan.nextLine();

				pstmt.setString(1, name);
				pstmt.setString(2, memo);
				pstmt.executeUpdate();
				System.out.println("visitor 테이블에 데이터 삽입 완료");
				System.out.print("계속 입력하겠습니까?(y/n) ");
				String aws = scan.nextLine();
				if (aws.equalsIgnoreCase("y")) {
					continue;
				}
				break;
			}
			result = true;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQL.close(conn);
		return result;
	}

	public List<VisitorVO> r() {
		Connection conn = MySQL.connect();
		List<VisitorVO> vlist = null;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"select id, name, date_format(writedate, '%Y년 %m월 %d일') writedate, memo from visitor order by writedate desc");
			vlist = new ArrayList<VisitorVO>();
			VisitorVO vo;
			while (rs.next()) {
				vo = new VisitorVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setWriteDate(rs.getString("writedate"));
				vo.setMemo(rs.getString("memo"));
				vlist.add(vo);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQL.close(conn);
		return vlist;
	}

	public boolean u(Scanner scan, int id) {
		boolean result = false;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("update visitor set name = ?,  memo = ? where id = ?")) {
			System.out.print("수정할 작성자 이름을 입력하세요 : ");
			String name = scan.nextLine();
			System.out.print("수정할 글의 내용을 입력하세요 : ");
			String memo = scan.nextLine();
			pstmt.setString(1, name);
			pstmt.setString(2, memo);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();		
			result = true;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQL.close(conn);
		return result;
	}

	public boolean d(int id) {
		boolean result = false;
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("delete from visitor where id = ?")) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			result = true;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQL.close(conn);
		return result;
	}
}
