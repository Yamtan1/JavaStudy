package memberDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import memberVo.Member;

public class Dbcon {
	
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String uri = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";
		
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(uri, uid, upw);
			if(conn != null) {
				System.out.println("DB접속 성공....");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
