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

public class Customer {
	
	private int c_code;
	private String c_name;
	private String c_ceo;
	private String c_addr;
	private String c_phone;
	
	
	public void insertCustomer() throws ClassNotFoundException, SQLException{
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();

		c_code = sc.nextInt();
		sc.nextLine();
		c_name = sc.nextLine();
		c_ceo = sc.nextLine();
		c_addr = sc.nextLine();
		c_phone = sc.nextLine();
		
		String query = "INSERT INTO customer VALUES ( ?, ?, ?, ?, ?)"; 
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, c_code);
		pstmt.setString(2, c_name);
		pstmt.setString(3, c_ceo);
		pstmt.setString(4, c_addr);
		pstmt.setString(5, c_phone);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	
	}
	
	public void deleteCustomer() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();
		
		c_code = sc.nextInt();
		sc.nextLine();
		
		String query = "DELETE FROM customer WHERE c_code = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, c_code);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	
	}
	
	public void updateCustomer() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Dbcon.connect();
		
		c_addr = sc.nextLine();
		c_code = sc.nextInt();
		
		String query = "UPDATE customer SET c_addr = ? WHERE c_code = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, c_addr);
		pstmt.setInt(2, c_code);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();	
	}
	public void selectCustomer() throws ClassNotFoundException, SQLException {
		Connection conn = Dbcon.connect();
		
		String query = "SELECT * FROM customer";
				
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Customer> list = new ArrayList<>();
		
		while(rs.next()) {
			Customer c = new Customer();
			c.setC_code(rs.getInt("c_code"));
			c.setC_name(rs.getString("c_name"));
			c.setC_ceo(rs.getString("c_ceo"));
			c.setC_addr(rs.getString("c_addr"));
			c.setC_phone(rs.getString("c_phone"));
			list.add(c);
		}
		
		for(Customer c : list) {
			System.out.println(c);
		}
	}
	
}
