package Study0411;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest_Insert2 {
	
	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String password = "1234";
		
		Connection conn = DriverManager.getConnection(url, id, password);
		
		String id2 = "zxc123";
		String pw = "1234567";
		String name = "xman";
		String phone = "010-7771-7777";
		String grade = "B";
		
		String query = "INSERT INTO tbl_member VALUES ( ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id2);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, pw);
		pstmt.setString(5, grade);
		//Statement stmt = conn.createStatement();
		
		
		
		//int result = stmt.executeUpdate(query);
		int result = pstmt.executeUpdate(); //PreparedStatement 사용 시 쿼리를 넣지 않음
		
		System.out.println("result" + result);
	}
}
