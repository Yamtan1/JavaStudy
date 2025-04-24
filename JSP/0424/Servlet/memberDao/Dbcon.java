package memberDao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbcon {
	
	protected static Connection conn;
	
	public static Connection getConnection() throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 
	 	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	 	String id = "green";
	 	String pw = "1234";
	 	
	 	conn = DriverManager.getConnection(url, id, pw); 
	 	
	 	return conn;	}

}

	
