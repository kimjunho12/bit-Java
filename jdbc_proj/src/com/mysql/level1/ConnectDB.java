package com.mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
            String user = "root";
            String passwd = "1234";
            Connection conn = DriverManager.getConnection(url, user, passwd);
            conn.close();
            System.out.println("MySQL연결 성공");
        } catch (Exception e) {
            System.out.println("MySQL 연결 실패");
            System.out.println("사유" + e.getMessage());
        }
    }
}
