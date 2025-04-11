package Member0411;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	
	private Statement stmt;
	
	public Select (Statement stmt) {
		this.stmt = stmt;
	}
	
	public void selectBoard() throws SQLException {
		String query = "SELECT * FROM tbl_board";
		ResultSet rs = stmt.executeQuery(query); //실행하겠다 라는 코드
		
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
					
			Board.addBoard(board);
		}
		System.out.println("전체 게시글:");
        for (Board b1 : Board.getBoardList()) {
            System.out.println(b1);
        }
	 }
		
	}

