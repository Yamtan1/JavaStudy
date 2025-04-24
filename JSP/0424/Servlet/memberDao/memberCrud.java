package memberDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import memberVo.Member;

public class memberCrud  {

	private Connection conn;
	
	public void insert(Member member) throws Exception {
		conn= Dbcon.getConnection();
		
		String query = "INSERT INTO member_tbl_02 VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, member.getCustno());
		pstmt.setString(2, member.getCustname());
		pstmt.setString(3, member.getPhone());
		pstmt.setString(4, member.getAddress());
		pstmt.setString(5, member.getJoindate());
		pstmt.setString(6, member.getGrade());
		pstmt.setString(7, member.getCity());
		
		pstmt.executeUpdate();			
	}
	
	public List<Member> select() throws Exception{
		conn= Dbcon.getConnection();
		
		String query = "SELECT * FROM member_tbl_02";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<Member> list = new ArrayList<>();
		
		while(rs.next()) {
			
			Member m = new Member();
	        m.setCustno(rs.getString("custno"));
	        m.setCustname(rs.getString("custname"));
	        m.setPhone(rs.getString("phone"));
	        m.setAddress(rs.getString("address"));
	        m.setJoindate(rs.getString("joindate"));
	        m.setGrade(rs.getString("grade"));
	        m.setCity(rs.getString("city"));
	        list.add(m);
		}
		return list;		
	}
	
	public void update(Member member) throws Exception {
		conn= Dbcon.getConnection();
		
		String query = "UPDATE member_tbl_02 SET custname = ?, phone = ?, address = ?, joindate = ?, grade = ?, city = ? WHERE custno = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, member.getCustname());
		pstmt.setString(2, member.getPhone());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getJoindate());
		pstmt.setString(5, member.getGrade());
		pstmt.setString(6, member.getCity());
		pstmt.setString(7, member.getCustno());
		
		pstmt.executeUpdate();
		
	}
	
	
}
