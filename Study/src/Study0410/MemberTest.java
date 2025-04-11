package Study0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Board> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String pw = "1234";
		
		Connection conn = DriverManager.getConnection(url, id, pw);
		Statement stmt = conn.createStatement();
		System.out.println("회원가입 진행");
		Member m1 = new Member();
		System.out.println("가입할 아이디를 입력해주세요");
		m1.setId(sc.nextLine());  
		System.out.println("비밀번호를 입력해주세요");
		m1.setPw(sc.nextLine());
		System.out.println("연락처를 입력해주세요");
		m1.setPhone(sc.nextLine());
		System.out.println("이름을 입력해주세요");
		m1.setName(sc.nextLine());
		System.out.println("등급을 입력해주세요");
		String temp = sc.nextLine();
		m1.setGrade(temp.charAt(0));
		System.out.println("회원가입이 완료 되었습니다.");

		String query = "INSERT INTO tbl_member VALUES (" + 
				"'" + m1.getId() +"'"+","+
				"'" + m1.getName() +"'"+","+
				"'" + m1.getPhone() +"'"+","+
				"'" + m1.getPw() +"'"+","+
				"'" + m1.getGrade() +"'"+")";
				
		
		 int result = stmt.executeUpdate(query);
		//System.out.println("result" + result); 잘적용 되었는지 확인
		 Statement stmt3 = conn.createStatement();
		 while(true) {
		 System.out.println("메인 메뉴");
		 System.out.println("게시글을 작성하려면 1번 게시글을 조회는 2번을 눌러주세요");
		 int input = sc.nextInt();
		 sc.nextLine();
		 if(input == 1) {
			 System.out.println("게시글을 작성합니다.");
			 Board b1 = new Board();
			 System.out.println("게시글 번호를 입력해주세요");
			 b1.setBno(sc.nextLine());
			 System.out.println("게시글의 제목을 입력해주세요");
			 b1.setTitle(sc.nextLine());
			 System.out.println("게시글의 내용을 입력해주세요");
			 b1.setContent(sc.nextLine());
		 
			 String query3 = "INSERT INTO tbl_board VALUES (" + 
						"'" + b1.getBno() +"'"+","+
						"'" + b1.getTitle() +"'"+","+
						"'" + b1.getContent() +"'"+","+
						"'" + m1.getId() +"'"+","+ "SYSDATE" + ")";
			 System.out.println("게시글 작성이 완료되었습니다.");
			
			 int result3 = stmt3.executeUpdate(query3);
		 	
		 	Statement stmt2 = conn.createStatement();
		 	String query2 = "SELECT * FROM tbl_board";
			ResultSet rs = stmt2.executeQuery(query2); //실행하겠다 라는 코드
			
				//rs의 다음자료가 있으면 true 없으면 false
				//Member member = new Member(); 여기에생성하면 같은데이터만 출력됨.
			while(rs.next()) {
				Board board = new Board();
				String bno = rs.getString("bno"); 
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writter = rs.getString("writter");
				String regdate = rs.getString("regdate");
				
				board.setBno(bno);
				board.setTitle(title);
				board.setContent(content);
				board.setWritter(writter);;
				board.setRegdate(regdate);
						
				list.add(board);
			}
				for(Board b : list) {
					System.out.println(b);
				} 
		 }
		 else if(input == 2) {
			 Statement stmt2 = conn.createStatement();
			 	String query2 = "SELECT * FROM tbl_board";
				ResultSet rs = stmt2.executeQuery(query2); //실행하겠다 라는 코드
				
					//rs의 다음자료가 있으면 true 없으면 false
					//Member member = new Member(); 여기에생성하면 같은데이터만 출력됨.
				
				System.out.println("1: 게시글 전체조회 2: 게시글 선택조회");
				int input2 = sc.nextInt();
				sc.nextLine();
				if(input2 == 1) {
				while(rs.next()) {	
					Board board = new Board();
					String bno = rs.getString("bno"); 
					String title = rs.getString("title");
					String content = rs.getString("content");
					String writter = rs.getString("writter");
					String regdate = rs.getString("regdate");
					
					board.setBno(bno);
					board.setTitle(title);
					board.setContent(content);
					board.setWritter(writter);;
					board.setRegdate(regdate);
							
					list.add(board);
				}
					for(Board b : list) {
						System.out.println(b);
					}
				}
				else if(input2 == 2) {
					System.out.println("조회할 게시글의 번호를 입력해주세요");
					String input3 = sc.nextLine();
					for(int i =0 ; i < list.size(); i++) {
						if(input3.equals(list.get(i).getBno())) {
							System.out.println(list.get(i));
						}
					}
				}
		 }
	 }
}
}