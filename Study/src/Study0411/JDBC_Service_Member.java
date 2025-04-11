package Study0411;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class JDBC_Service_Member implements Ijdbc_Service<Member> {

	
	//DB에 입력 (INSERT)
	@Override
	public void insert() {
		
	}
	@Override
	//DB 데이터 수정(UPDATE)
	public void update() {
		
	}
	@Override
	//DB 데이터 삭제(DELETE)
	public void delete() {
		
	}
	@Override
	//DB 데이터 조회(SELECT)
	public ArrayList<Member> select() {
		ArrayList<Member> list = new ArrayList<>();
		//DB에 접속(Connection)
		
		//DB에 쿼리 실행(Statement)
		String query = "SELECT * FROM tbl_member";
		//DB로부터 데이터 받기(ResultsSet)
		
		//결과 반환해주기
		
		return list;
	}
}
