package com.mysql.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableLab {
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
            stmt.executeUpdate(
                    "CREATE table meeting(id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(18), title VARCHAR(120), meetingdate DATETIME)");
            System.out.println("meeting 테이블 생성");
        } catch (SQLException se) {
            System.err.println("테이블 생성에 실패 하였습니다.\nCause : " + se.getMessage());
        }
    }
}
