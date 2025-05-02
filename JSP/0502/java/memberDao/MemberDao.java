package memberDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import memberVo.Member;


public class MemberDao {

	Connection conn = Dbcon.getConnection();
	
	public void insert(Member member) {
		
		String query = "INSERT INTO member2 VALUES (?, ?, ?)";
		
		try(PreparedStatement pstmt = conn.prepareStatement(query)) {
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean selectId(String id) {
		
		String query = "SELECT id FROM member2 WHERE id = ?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	        pstmt.setString(1, id);
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {  // 아이디가 존재하면 true 반환
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;  // 아이디가 존재하지 않으면 false 반환
		
	}
}
