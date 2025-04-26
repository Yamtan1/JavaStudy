package productDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcon {

	
public static Connection connect() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 
	 	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	 	String id = "green";
	 	String pw = "1234";
	 	
	 	Connection conn = DriverManager.getConnection(url, id, pw); 
	 	System.out.println("연결완료");
	 	return conn;

	}
}
