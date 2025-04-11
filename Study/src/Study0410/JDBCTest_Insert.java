package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest_Insert {
	
	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String password = "1234";
		
		Connection conn = DriverManager.getConnection(url, id, password);
		
		Statement stmt = conn.createStatement();
		
		String query = "INSERT INTO tbl_member VALUES ('abc1233','덴버','010-8988-8888', '12013', 'C')";
		
		int result = stmt.executeUpdate(query);
		
		System.out.println("result" + result);
	}
}
