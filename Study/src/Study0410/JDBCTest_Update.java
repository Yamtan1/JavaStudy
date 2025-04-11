package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest_Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String password = "1234";
		
		Connection conn = DriverManager.getConnection(url, id, password);
		
		Statement stmt = conn.createStatement();
		
		String query = "UPDATE tbl_member SET name = '홍길순' WHERE name = '홍길동'";
		int result = stmt.executeUpdate(query);
		
		System.out.println("result" + result);
	}

}
