package com.mysql.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataLab {
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
            stmt.executeUpdate("INSERT INTO meeting(name, title, meetingdate) VALUES ('둘리', '자바 공부', NOW())");
            stmt.executeUpdate("INSERT INTO meeting(name, title, meetingdate) VALUES ('또치', '영화 보기', '2021-12-25 12:00')");
            stmt.executeUpdate("INSERT INTO meeting(name, title, meetingdate) VALUES ('도우너', 'PC방', '2022-01-01')");
            System.out.println("meeting 테이블에 데이터 삽입 완료 생성");
            
        } catch (SQLException se) {
            System.err.println("데이터 삽입에 실패 하였습니다.\nCause : " + se.getMessage());
        }
    }
}
