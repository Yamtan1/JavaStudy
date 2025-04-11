package Study0411;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//0. 회원정보(나중에 Scanner로 입력받을 것)
		String id = "aaa";
		String pw = "1234";
		String name = "Ann";
		String phone = "010-9999-0000";
		char grade = 'A';
		
		//1 회원정보 Member 인스턴스에 저장하기
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setPhone(phone);
		member.setGrade(grade);
		
		//DB접속하기
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			
			String url = "jdbc:oracle:thin:@localhost:1521:testdb";
			String id1 = "green";
			String pw1 = "1234";
			//쿼리 실행
			Connection conn = DriverManager.getConnection(url, id1, pw1);
			
			String query = "INSERT INTO tbl_member VALUES ( ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getPw());
			String g = member.getGrade() + "";
			pstmt.setString(5, g);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("회원가입이 완료되었습니다"); 
			}
			else {
				System.out.println("회원정보가 저장안됨.");
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<>(); //아이디랑 비밀번호 모두 스트링
		
		
		
	}
}
