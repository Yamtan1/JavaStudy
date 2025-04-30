package AccountService;

import java.sql.Connection;
import java.sql.SQLException;

import tansDAO.AccountDAO;

public class Service {
	
	private AccountDAO accountDAO = new AccountDAO();

    public void transfer(String fromAccountId, String toAccountId, double amount) throws SQLException {
        Connection conn = null;

        try {
            conn = AccountDAO.getConnection();
            conn.setAutoCommit(false); // 트랜잭션 시작

            int result1 = accountDAO.withdraw(fromAccountId, amount);
            if (result1 == 0) {
                throw new SQLException("잔액 부족 또는 출금 계좌 없음");
            }

            int result2 = accountDAO.deposit(toAccountId, amount);
            if (result2 == 0) {
                throw new SQLException("입금 계좌 없음");
            }

            conn.commit(); // 성공 시 커밋

        } catch (SQLException e) {
        	if (conn != null) {
                try {
                    conn.rollback(); // 실패 시 롤백
                } catch (SQLException ex) {
                    ex.printStackTrace(); // 롤백 도중 에러 발생시 출력
                }
            } 
            throw e; // 예외 다시 던짐
        } finally {
            if (conn != null) conn.close(); // 연결 닫기
        }
    }
}