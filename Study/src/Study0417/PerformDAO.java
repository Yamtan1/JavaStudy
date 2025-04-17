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
public class PerformDAO {
	
	private int staff_no;
	private int p_code;
	private int c_code;
	private int qty;
	private int cost;
	private String sale_date;
	
	
	
	public void insert() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		Connection conn = Dbcon.connect();

		String query = "INSERT INTO perform VALUES (?, ?, ?, ?,?,?)";
		
		System.out.println("사원번호를 입력해주세요");
		staff_no = sc.nextInt();
		System.out.println("상품코드를 입력해주세요");
		p_code = sc.nextInt();
		System.out.println("거래처 코드를 입력해주세요");
		c_code = sc.nextInt();
		System.out.println("판매수량을 입력해주세요");
		qty = sc.nextInt();
		System.out.println("판매가격을 입력해주세요");
		cost = sc.nextInt();
		sc.nextLine();
		System.out.println("판매날짜를 입력해주세요");
		sale_date = sc.nextLine();
		
		PreparedStatement pstmt = conn.prepareStatement(query);

		pstmt.setInt(1, staff_no);
		pstmt.setInt(2, p_code);
		pstmt.setInt(3, c_code);
		pstmt.setInt(4, qty);
		pstmt.setInt(5, cost);
		pstmt.setString(6, sale_date);

		pstmt.executeUpdate();

		pstmt.close();
		
		
		String checkStockQuery = "SELECT s_qty FROM stock WHERE p_code = ?";
	    pstmt = conn.prepareStatement(checkStockQuery);
	    pstmt.setInt(1, p_code);
	    ResultSet rs = pstmt.executeQuery();
	    if (rs.next()) {
	        int currentQty = rs.getInt("s_qty");
	        int newQty = currentQty - qty;

	        String updateStockQuery = "UPDATE stock SET s_qty = ? WHERE p_code = ?";
	        PreparedStatement updatePstmt = conn.prepareStatement(updateStockQuery);
	        updatePstmt.setInt(1, newQty);
	        updatePstmt.setInt(2, p_code);
	        updatePstmt.executeUpdate();
	        updatePstmt.close();
	    }
	}

	// 데이터 수정 update

	public void update() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		String query = "UPDATE perform SET cost = ? WHERE sale_date = ?";
		Connection conn = Dbcon.connect();

		PreparedStatement pstmt = conn.prepareStatement(query);
		
		cost = sc.nextInt();
		sc.nextLine();
		
		sale_date = sc.nextLine();
		
		pstmt.setInt(1, cost);
		pstmt.setString(2, sale_date);
		

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	// 데이터 삭제 delete

	public void delete() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		String query = "DELETE perform WHERE sale_date = ?";

		Connection conn = Dbcon.connect();

		PreparedStatement pstmt = conn.prepareStatement(query);
		
		sale_date = sc.nextLine();
		
		pstmt.setString(1, sale_date);
		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	// 데이터 조회 select

	public void selectAll() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		// db 접속(Connection)
		Connection conn = Dbcon.connect();
		// 쿼리 준비
		String query = "SELECT * FROM perform";
		// 쿼리 실행(Statement)
		PreparedStatement pstmt = conn.prepareStatement(query);

		ResultSet rs = pstmt.executeQuery();// excute 실행하다

		ArrayList<PerformDAO> list = new ArrayList<>();
		// db 로부터 받은 데이터 받기(ResultSet)

		while (rs.next()) {
			PerformDAO p = new PerformDAO();
			p.setStaff_no(rs.getInt("staff_no"));
			p.setP_code(rs.getInt("p_code"));
			p.setC_code(rs.getInt("c_code"));
			p.setQty(rs.getInt("qty"));
			p.setCost(rs.getInt("cost"));
			p.setSale_date(rs.getString("sale_date"));
		
			list.add(p);
			
			}
		
		for(PerformDAO a : list) {
				System.out.println(a);
			
		}
		
	}
}
