package com.mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectData3 {
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
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn
						.prepareStatement("select name, score from student where score>=  ? order by score desc");
				Scanner scan = new Scanner(System.in);) {
			System.out.print("점수를 입력하세요 : ");
			int score = Integer.parseInt(scan.nextLine());
			pstmt.setInt(1, score);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("[ 점수가 " + score + " 이상인 학생 이름(점수가 높은 순) ]");
				do {
					System.out.println(rs.getString("name") + " : " + rs.getInt("score"));
				} while (rs.next());
			} else
				System.out.println("점수가 " + score + " 이상인 학생은 존재하지 않습니다.");
			System.out.println("수행 종료...");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
