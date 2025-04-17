package Study0417;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcon {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	private static String id = "green";
	private static String pw = "1234";
		
		
		
		public static Connection connect() throws ClassNotFoundException, SQLException {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Connection conn = DriverManager.getConnection(url, id, pw);
			
			conn.setAutoCommit(true);
			
			return conn;
		}
}
