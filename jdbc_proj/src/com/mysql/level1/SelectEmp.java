package com.mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEmp {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("해당 클래스를 찾을 수 없습니다." + e.getMessage());
            return;
        }
        String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String passwd = "1234";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT ename, sal, hiredate FROM emp");
            while (rs.next()) {
                System.out.println(rs.getString("ename") + "," + rs.getDate("hiredate") + "," + rs.getInt("sal"));
            }
        } catch (SQLException se1) {
            System.err.println(se1.getMessage());
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException se2) {
                System.err.println(se2.getMessage());
            }
        }
    }
}
