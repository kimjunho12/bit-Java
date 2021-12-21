package com.mysql.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDataLab {
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
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT id, name, title, DATE_FORMAT(meetingdate, '%Y년 %c월 %e일 %H시 %i분') 'meetingdate' FROM meeting");
            while (rs.next()) {
                System.out.printf("[id가 %d인 친구]\n", rs.getInt("id"));
                System.out.println("친구이름 : " + rs.getNString("name"));
                System.out.println("미팅목적 : " + rs.getNString("title"));
                System.out.println("미팅시간 : " + rs.getNString("meetingdate"));
            }

        } catch (SQLException se) {
            System.err.println("데이터 검색에 실패 하였습니다.\nCause : " + se.getMessage());
        }
    }
}
