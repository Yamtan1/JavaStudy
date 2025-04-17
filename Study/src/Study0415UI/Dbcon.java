package Study0415UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Dbcon {

	Statement stmt;
	
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String pw = "1234";
		
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		stmt = conn.createStatement();
	}

}
