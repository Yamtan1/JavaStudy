package DbCon;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class Dbcon {
	
	Connection conn;
		
	public Dbcon() {
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("dbcp_myoracle");
			
			conn = ds.getConnection();
			
			if(conn != null) {
				System.out.println("db 커넥션 풀 연결 성공");
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(conn != null)
				conn.close();
		} catch(Exception e) {
			
		}
	}
		
	
	
}
