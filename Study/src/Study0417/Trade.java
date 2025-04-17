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
public class Trade {
	private int t_seq;
	private int p_code;
	private int c_code;
	private String t_date;
	private String t_qty;
	private int t_cost;
	
	public void insertTrade() throws ClassNotFoundException, SQLException{
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();
		
		p_code = sc.nextInt();
		sc.nextLine();
		c_code = sc.nextInt();
		sc.nextLine();
		t_date = sc.nextLine();
		t_qty = sc.nextLine();
		t_cost = sc.nextInt();
		sc.nextLine();
		
		String query = "INSERT INTO trade VALUES ( t_seq.nextval, ?, ?, ?, ?, ? )";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, p_code);
		pstmt.setInt(2, c_code);
		pstmt.setString(3, t_date);
		pstmt.setString(4, t_qty);
		pstmt.setInt(5, t_cost);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	
	}
	
	public void deleteTrade() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();
		
		int t_seq = sc.nextInt();
		sc.nextLine();
		
		String query = "DELETE FROM tarde WHERE t_seq = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, t_seq);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	
	}
	
	public void updateTrade() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();
		
		t_cost = sc.nextInt();
		int t_seq = sc.nextInt();
		
		String query = "UPDATE trade SET t_cost = ? WHERE t_seq = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, t_cost);
		pstmt.setInt(2, t_seq);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();	
	}
	public void selectTrade() throws ClassNotFoundException, SQLException {
		Connection conn = Dbcon.connect();
		
		String query = "SELECT * FROM trade";
				
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Trade> list = new ArrayList<>();
		
		while(rs.next()) {
			Trade t = new Trade();
			t.setT_seq(rs.getInt("t_seq"));
			t.setP_code(rs.getInt("p_code"));
			t.setC_code(rs.getInt("c_code"));
			t.setT_date(rs.getString("t_date"));
			t.setT_qty(rs.getString("t_qty"));
			t.setT_cost(rs.getInt("t_cost"));
			list.add(t);
		}
		
		for(Trade t1 : list) {
			System.out.println(t1);
		}
	}
}
