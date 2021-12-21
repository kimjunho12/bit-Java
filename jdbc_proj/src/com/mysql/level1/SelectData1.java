package com.mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		}
		String url = "jdbc:mysql://localhost:3306/jdbcdb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);		// try/resource 구문
				Statement stmt = conn.createStatement()) {							// try에서 생성한 변수 resource는 블럭이 끝나면 자동 close	
			ResultSet rs = stmt.executeQuery("select * from student");				// but closable interface를 구현한 class만 생성가능
			while (rs.next()) {
				System.out.println(rs.getString("name") + "학생은 " + rs.getInt("score") + "점 입니다.");
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
