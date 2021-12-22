package com.mysql.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Prob_KJH {
    public static void main(String[] args) {
		printEmp("A");
		printEmp("Q");
		printEmp("T");
	}
	
    public static void printEmp(String pn) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("[오류발생] " + e.getMessage());
            return;
        }
        String url = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String passwd = "1234";
        try (Connection conn = DriverManager.getConnection(url, user, passwd);
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT e.ename, l.city From emp e JOIN dept d USING (deptno) JOIN locations l USING (loc_code) WHERE e.ename LIKE ?");) {
            pstmt.setString(1, "%" + pn + "%");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.printf("** 이름에 %s 문자가 들어간 직원들의 리스트 **\n", pn);
                do {
                    System.out.printf("%s(%s)\n", rs.getString("ename"), rs.getString("city"));
                } while (rs.next());
            } else {
                System.out.printf("~~ 이름에 %s 문자가 들어간 직원들은 없음 ~~\n", pn);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("[오류발생] " + e.getMessage());
        }
    }
}
