package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDCBTest_Delete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String password = "1234";
		
		Connection conn = DriverManager.getConnection(url, id, password); 
		
		Statement stmt = conn.createStatement();
		
		String query = "DELETE FROM tbl_member WHERE name = '덴버'";
		int result = stmt.executeUpdate(query);
		
		System.out.println("result" + result);
	}

}
