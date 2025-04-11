package Study0411;

import java.sql.Connection;
import java.util.ArrayList;

public class JDBC_Service_Board implements Ijdbc_Service<Board> {
		//Connection conn = DBcon.getConnection();
	
		//DB에 입력 (INSERT)
		public void insert() {
			
		}
		//DB 데이터 수정(UPDATE)
		public void update() {
			
		}
		//DB 데이터 삭제(DELETE)
		public void delete() {
			
		}
		//DB 데이터 조회(SELECT)
		public ArrayList<Board> select() {
			ArrayList<Board> list = new ArrayList<>();
			//DB에 접속(Connection)
			
			//DB에 쿼리 실행(Statement)
			String query = "SELECT * FROM tbl_board";
			//DB로부터 데이터 받기(ResultsSet)
			
			//결과 반환해주기
			
			return list;
		}
}
