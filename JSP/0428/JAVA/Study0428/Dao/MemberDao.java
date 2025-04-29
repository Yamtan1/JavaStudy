package Study0428.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Study0428.Dto.MemberDto;

public class MemberDao {
	private static MemberDao dao = new MemberDao();
	
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	Connection conn = DbUtil.getConnection();
	
	public List<MemberDto> selectAll() {
		List<MemberDto> list = new ArrayList<>();
		String query = "SELECT * FROM tbl_member";
		// PreparedStatement pstmt = null; 
		// ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(query); //트라이에 괄호를 쳐놓고 자원을 생성하는 코드를 써놓으면 작업을 다하고 자동으로 닫아준다
			ResultSet rs = pstmt.executeQuery();) {
			
			while(rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String pw = rs.getString("pw");
			String grade = rs.getString("grade");

			MemberDto m = new MemberDto(id, name, phone, pw, grade);
			
			list.add(m);
			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} /*finally {
			DbUtil.close(conn, pstmt, rs);
		}*/
		return list;
	}
	
	public void insert() {
		String query = "INSERT INTO tbl_member VALUES (?, ?, ?, ?, ?)";

		try(PreparedStatement pstmt = conn.prepareStatement(query)) {
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update() {
		String query = "UPDATE tbl_member SET grade = ? WHERE id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete() {
		String query = "DELETE FROM tbl_member WHERE id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
