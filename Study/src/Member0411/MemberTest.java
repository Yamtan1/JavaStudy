package MemberPack0411;

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
		Scanner sc = new Scanner(System.in);
		Member m1 = new Member();
		Board b1 = new Board();
		DbCon db = new DbCon();
		
		db.connect();
		InsertMember in = new InsertMember(db.getStmt());
		UpdateBoard up = new UpdateBoard(db.getStmt());
		Select se = new Select(db.getStmt()); 
		Delete de = new Delete(db.getStmt());
		/* in.insertMem(m1);
		up.update(b1, m1);
		se.selectBoard(); */
		de.deleteMember("14231asvf");
				 
		 
		 /*	Statement stmt2 = conn.createStatement();
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
						board.setWritter(writter);
						board.setRegdate(regdate);
						
						list.add(board);
					}
					boolean found = false;
					for(Board b : list) {
						if(input3.equals(b.getBno())) {
							System.out.println(b);
							found = true;
							break;
						}
					}
					if(!found) {
						System.out.println("해당 번호의 게시글이 없습니다.");
					}
				}
		 }
	 } */
}
}