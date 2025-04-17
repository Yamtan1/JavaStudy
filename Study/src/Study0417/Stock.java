package Study0417;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Stock {
	
	private int p_code;
	private String s_qty;

	public void insertStock() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();

		p_code = sc.nextInt();
		sc.nextLine();
		s_qty = sc.nextLine();		
		String query = "INSERT INTO stock VALUES ( ?, ? )"; 
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, p_code);
		pstmt.setString(2, s_qty);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public void deleteStock() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();
		
		p_code = sc.nextInt();
		sc.nextLine();
		
		String query = "DELETE FROM stock WHERE p_code = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, p_code);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public void selectStock() throws ClassNotFoundException, SQLException {
		Connection conn = Dbcon.connect();
		
		String query = "SELECT * FROM stock";
				
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Stock> list = new ArrayList<>();
		
		while(rs.next()) {
			Stock s = new Stock();
			s.setP_code(rs.getInt("p_code"));
			s.setS_qty(rs.getString("s_qty"));
			
			list.add(s);
		}
		
		for(Stock st : list) {
			System.out.println(st);
		}
	}
	
	public void updateStock() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();
		
		s_qty = sc.nextLine();
		p_code = sc.nextInt();
		sc.nextLine();
		
		String query = "UPDATE stock SET s_qty = ? WHERE p_code = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, s_qty);
		pstmt.setInt(2, p_code);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();	
		
	}
}
