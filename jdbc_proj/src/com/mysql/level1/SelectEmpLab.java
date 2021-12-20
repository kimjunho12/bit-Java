package com.mysql.level1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {
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
        boolean random = new Random().nextBoolean();
        try {
            conn = DriverManager.getConnection(url, user, passwd);
            stmt = conn.createStatement();
            if (random) {
                rs = stmt.executeQuery("SELECT ename, Format(sal, 0) sal FROM emp;");
                while (rs.next()) {
                    System.out.printf("%s\t직원의\t월급은\t%s원입니다.%n", rs.getString("ename"), rs.getString("sal"));
                }
            } else {
                rs = stmt.executeQuery(
                        "SELECT ename, DATE_FORMAT(hiredate, \"%Y년 %m월 %d일\") hiredate FROM emp ORDER by hiredate;");
                while (rs.next()) {
                    System.out.printf("%s\t직원은\t%s에 입사하였습니다.%n", rs.getString("ename"), rs.getString("hiredate"));
                }
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
