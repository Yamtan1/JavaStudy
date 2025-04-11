package Study0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest_Select {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Member> list = new ArrayList<>();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb"; //데이터베이스 주소
		String user = "green"; //데이터 베이스 아이디
		String password = "1234"; // 데이터베이스 패스워드
		//접속 담당 - Connection
		Connection conn = DriverManager.getConnection(url, user, password);
		//쿼리 실행 - Stetement  import시 sql 꺼 사용!!!!! 중요!!!!!!!!!!!!!!!
		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM tbl_member";
		ResultSet rs = stmt.executeQuery(query); //실행하겠다 라는 코드
		
		//rs의 다음자료가 있으면 true 없으면 false
			//Member member = new Member(); 여기에생성하면 같은데이터만 출력됨.
		while(rs.next()) {
			Member member = new Member();
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String grade_temp = rs.getString("grade");
			char grade = grade_temp.charAt(0);
					
			member.setId(id);
			member.setPw(pw);
			member.setName(name);
			member.setPhone(phone);
			member.setGrade(grade);
					
			list.add(member);
		}
			for(Member m : list) {
				System.out.println(m);
			} 
		
	
		/*rs.next(); //반복문을 없애도 rs.next가 있어야 실행이 됨. 처음 책을넘기면 표지를 넘기듯이 한번 넘겨줘야함
		Member member = new Member();
		String id = rs.getString("id");
		String pw = rs.getString("pw");
		String name = rs.getString("name");
		String phone = rs.getString("phone");
		String grade_temp = rs.getString("grade");
		char grade = grade_temp.charAt(0);
		
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setPhone(phone);
		member.setGrade(grade);
		
		list.add(member);
		
		System.out.println(member); */
		
		
		
	}

}
