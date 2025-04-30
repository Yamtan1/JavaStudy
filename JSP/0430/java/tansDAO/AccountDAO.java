package tansDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDAO {
	
	String fromAccount;
	String toAccount;
	String amount;
	
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
	
	public int withdraw(String fromAccountId, double amount) throws SQLException {
		Connection conn = null;
		conn = getConnection();
		
		PreparedStatement withdrawStmt = null;
		
		String withdrawSql= "UPDATE accounts SET balance = balance - ? "+ "WHERE account_id = ? AND balance >= ? ";
		withdrawStmt = conn.prepareStatement(withdrawSql);
		withdrawStmt.setDouble(1, amount);
		withdrawStmt.setString(2, fromAccountId);
		withdrawStmt.setDouble(3, amount);
		int withdrawResult = withdrawStmt.executeUpdate();
		if (withdrawStmt != null) withdrawStmt.close();
		
		return withdrawResult;
	}
	public int deposit(String toAccountId, double amount) throws SQLException {
		Connection conn = null;
		conn = getConnection();
		
		PreparedStatement depositStmt = null;
		
		String depositSql = "UPDATE accounts SET balance = balance + ? " + "WHERE account_id = ? ";
		depositStmt = conn.prepareStatement(depositSql);
		depositStmt.setDouble(1, amount);
		depositStmt.setString(2, toAccountId);
		int depositResult = depositStmt.executeUpdate();
		if (depositStmt != null) depositStmt.close();
		return depositResult;
	}
	
	/* public void transfer(String fromAccountId, String toAccountId, double amount) throws SQLException {
		
		Connection conn = null;
		PreparedStatement withdrawStmt = null;
		PreparedStatement depositStmt = null;
		conn = getConnection(); */
		
			/* try {
			conn.setAutoCommit(false); //트랜잭션 시작
			
			//출금 계좌에서 금액 차감
			String withdrawSql= "UPDATE accounts SET balance = balance - ? "+ "WHERE account_id = ? AND balance >= ? ";
			withdrawStmt = conn.prepareStatement(withdrawSql);
			withdrawStmt.setDouble(1, amount);
			withdrawStmt.setString(2, fromAccountId);
			withdrawStmt.setDouble(3, amount);
			int withdrawResult = withdrawStmt.executeUpdate();
			
			if (withdrawResult == 0 ) {
				throw new SQLException("잔액 부족 또는 계좌 없음");
			}
			//입금 계쫘에 금액 추가
			String depositSql = "UPDATE accounts SET balance = balance + ? " + "WHERE account_id = ? ";
			depositStmt = conn.prepareStatement(depositSql);
			depositStmt.setDouble(1, amount);
			depositStmt.setString(2, toAccountId);
			int depositResult = depositStmt.executeUpdate();
		
			if(depositResult == 0 ) {
				throw new SQLException("입금 계좌 없음");
			}
			conn.commit(); //트랜잭션 커밋
			} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback(); //오류 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			throw e;
		} finally {
			//리소스 해제
			if (withdrawStmt != null) withdrawStmt.close();
			if (depositStmt != null) depositStmt.close();
			if (conn != null) conn.close();
		} 
	} */
}
