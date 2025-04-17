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

public class Product  {
	
	private int p_code;
	private String p_name;
	private int p_cost;
	private String p_group;
	
	public void insertProduct() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();

		p_code = sc.nextInt();
		sc.nextLine();
		p_name = sc.nextLine();
		p_cost = sc.nextInt();
		sc.nextLine();
		p_group = sc.nextLine();
		
		String query = "INSERT INTO product VALUES ( ?, ?, ?, ? )"; 
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, p_code);
		pstmt.setString(2, p_name);
		pstmt.setInt(3, p_cost);
		pstmt.setString(4, p_group);
		
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public void deleteProduct() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();
		
		p_code = sc.nextInt();
		sc.nextLine();
		
		String query = "DELETE FROM product WHERE p_code = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, p_code);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public void selectProduct() throws ClassNotFoundException, SQLException {
		Connection conn = Dbcon.connect();
		
		String query = "SELECT * FROM product";
				
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Product> list = new ArrayList<>();
		
		while(rs.next()) {
			Product p = new Product();
			p.setP_code(rs.getInt("p_code"));
			p.setP_name(rs.getString("p_name"));
			p.setP_cost(rs.getInt("p_cost"));
			p.setP_group(rs.getString("p_group"));
			list.add(p);
		}
		
		for(Product pr : list) {
			System.out.println(pr);
		}
	}
	
	public void updateProduct() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();
		
		p_cost = sc.nextInt();
		sc.nextLine();
		p_code = sc.nextInt();
		sc.nextLine();
		
		String query = "UPDATE product SET p_cost = ? WHERE p_code = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, p_cost);
		pstmt.setInt(2, p_code);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();	
		
	}
}
