package Member0411;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateBoard {

	Scanner sc = new Scanner(System.in);
	private Statement stmt;
	
	public UpdateBoard(Statement stmt) {
		this.stmt = stmt;
	}
	
	public void update(Board b, Member m) throws SQLException {
		 System.out.println("메인 메뉴");
		 System.out.println("게시글을 작성하려면 1번 게시글을 조회는 2번을 눌러주세요");
		 int input = sc.nextInt();
		 sc.nextLine();
		 if(input == 1) {
			 System.out.println("게시글을 작성합니다.");
			 
			 System.out.println("게시글 번호를 입력해주세요");
			 b.setBno(sc.nextLine());
			 System.out.println("게시글의 제목을 입력해주세요");
			 b.setTitle(sc.nextLine());
			 System.out.println("게시글의 내용을 입력해주세요");
			 b.setContent(sc.nextLine());
			 
			 String query = "INSERT INTO tbl_board VALUES (" + 
						"'" + b.getBno() +"'"+","+
						"'" + b.getTitle() +"'"+","+
						"'" + b.getContent() +"'"+","+
						"'" + m.getId() +"'"+","+ "SYSDATE" + ")";
			 System.out.println("게시글 작성이 완료되었습니다.");
			
			 int result3 = stmt.executeUpdate(query);
		 }
	}
}
