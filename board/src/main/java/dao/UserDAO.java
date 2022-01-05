package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vo.UserVO;

public class UserDAO {
	public void create_user(UserVO vo) {
		Connection conn = MySQL.connect();
		try (PreparedStatement pstmt = conn.prepareStatement(
				"INSERT INTO user (name, email, pw, phone, register_date, last_date) VALUES (?, ?, ?, ?, now(), null)")) {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
