package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQL {
	public static Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Java 6 버전부터는 생략 가능
			String url = "jdbc:mysql://localhost:3306/jdbcdb?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "root";
			String passwd = "1234";
			conn = DriverManager.getConnection(url, user, passwd);						
		} catch (Exception e) {
			System.out.println("MYSQL 연결 실패");
			System.out.print("사유 : " + e.getMessage());
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			if (conn != null) 
				conn.close();
		} catch (Exception e) {
			System.out.println("MYSQL 닫기 실패");
			System.out.print("사유 : " + e.getMessage());
		}
	}
}