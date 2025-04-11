package MemberPack0411;

import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

private Statement stmt;
	
	public Delete (Statement stmt) {
		this.stmt = stmt;
	}
	public void deleteMember(String id) throws SQLException {
	
		String query = "DELETE FROM tbl_member WHERE id = " + "'"+ id +"'";
		stmt.executeUpdate(query);
		System.out.println("멤버삭제 되었습니다");
	}
	public void deleteBoard(int bno) throws SQLException {
		String query = "DELETE FROM tbl_board WHERE bno = " + bno;
		stmt.executeUpdate(query);
		System.out.println("게시글이 삭제 되었습니다");
	}
}
