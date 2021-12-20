package com.mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class UpdateData {
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
				PreparedStatement pstmt = conn.prepareStatement("update student set score = ? where name = ?");
				Scanner scan = new Scanner(System.in);){
			System.out.print("학생 이름을 입력하세요 : ");
		    String name = scan.nextLine();
			System.out.print("학생 점수를 입력하세요 : ");
			int score = Integer.parseInt(scan.nextLine());
			pstmt.setInt(1,  score);
		    pstmt.setString(2, name);
			int updateNum = pstmt.executeUpdate();
			System.out.println("student 테이블에서 " +updateNum + "행 변경 완료");						
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
