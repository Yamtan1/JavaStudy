package userDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbCon.DbConnect;
import userVo.userInfo;

public class Crud {

	Connection conn = DbConnect.getConnection();
	
	public void insertUser(userInfo user) {
		
		String query = "INSERT INTO rspuser VALUES (?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			
			pstmt.executeUpdate();
			System.out.println("회원가입 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public userInfo loginUser(userInfo user) {
		
		String query = "SELECT * FROM rspuser WHERE id = ? AND pw = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			
			ResultSet rs = pstmt.executeQuery();
			
			userInfo m = null;
			
			while(rs.next()) {
				m = new userInfo();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
			}
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}
}
