package memberDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import memberVo.memberVo;

public class memberDao {
	
	//등록
	public void insert (memberVo member) throws ClassNotFoundException, SQLException {
		Connection conn = Dbcon.connect();
		
		String query = "INSERT INTO member VALUES (?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getGrade());
		
		pstmt.executeUpdate();
	}
	
	public memberVo select(memberVo member) throws ClassNotFoundException, SQLException {
		
		Connection conn = Dbcon.connect();
		
		String query = "SELECT * FROM member WHERE id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, member.getId());
		ResultSet rs = pstmt.executeQuery();
		
		memberVo m = null;

	    if (rs.next()) {
	        m = new memberVo();
	        m.setId(rs.getString("id"));
	        m.setPw(rs.getString("pw"));
	        m.setName(rs.getString("name"));
	        m.setGrade(rs.getString("grade"));
	    }

	    return m;
				
	}
	public memberVo loginselect(memberVo member) throws ClassNotFoundException, SQLException {
		
		Connection conn = Dbcon.connect();
		
		String query = "SELECT * FROM member WHERE id = ? AND pw = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		ResultSet rs = pstmt.executeQuery();
		
		memberVo m = null;
		
	    if (rs.next()) {
	        m = new memberVo();
	        m.setId(rs.getString("id"));
	        m.setPw(rs.getString("pw"));
	        m.setName(rs.getString("name"));
	        m.setGrade(rs.getString("grade"));
	    }
	    return m;
	    
				
	}


}
