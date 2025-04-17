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


@Setter
@Getter
@ToString
public class P_ledgerDAO {
	
	private int p_code;
	private int c_code;
	private int p_qty;
	private int p_cost;
	private String p_date;
	
	
	
	public void insert() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		Connection conn = Dbcon.connect();

		String query = "INSERT INTO p_ledger (p_code, c_code, p_qty, p_cost, p_date) VALUES (?, ?, ?, ?, ?)";

	    System.out.print("상품코드: ");
	    int p_code = sc.nextInt();

	    // 0. product 테이블에 상품 존재 여부 확인
	    String checkProductQuery = "SELECT * FROM product WHERE p_code = ?";
	    PreparedStatement pstmt = conn.prepareStatement(checkProductQuery);
	    pstmt.setInt(1, p_code);

	    ResultSet rs = pstmt.executeQuery();
	    if (!rs.next()) {
	        // 상품이 존재하지 않으면 등록
	        sc.nextLine(); // 버퍼 클리어
	        System.out.print("신규 상품명: ");
	        String p_name = sc.nextLine();

	        String insertProductQuery = "INSERT INTO product (p_code, p_name) VALUES (?, ?)";
	        PreparedStatement insertProductStmt = conn.prepareStatement(insertProductQuery);
	        insertProductStmt.setInt(1, p_code);
	        insertProductStmt.setString(2, p_name);
	        insertProductStmt.executeUpdate();
	        insertProductStmt.close();

	        System.out.println("상품이 등록되지 않아, product 테이블에 신규 등록하였습니다.");
	    } else {
	        sc.nextLine(); // 버퍼 클리어
	    }
	    rs.close();
	    pstmt.close();

	    System.out.print("거래처코드: ");
	    int c_code = sc.nextInt();

	    System.out.print("수량: ");
	    int p_qty = sc.nextInt();

	    System.out.print("단가: ");
	    int p_cost = sc.nextInt();
	    sc.nextLine(); // 버퍼 클리어

	    System.out.print("날짜(YYYY-MM-DD): ");
	    String p_date = sc.nextLine();

	    // 1. p_ledger에 insert
	    pstmt = conn.prepareStatement(query);
	    pstmt.setInt(1, p_code);
	    pstmt.setInt(2, c_code);
	    pstmt.setInt(3, p_qty);
	    pstmt.setInt(4, p_cost);
	    pstmt.setString(5, p_date);
	    pstmt.executeUpdate();
	    pstmt.close();

	    // 2. stock 테이블 확인 및 업데이트
	    String checkStockQuery = "SELECT s_qty FROM stock WHERE p_code = ?";
	    pstmt = conn.prepareStatement(checkStockQuery);
	    pstmt.setInt(1, p_code);
	    rs = pstmt.executeQuery();

	    if (rs.next()) {
	        int currentQty = rs.getInt("s_qty");
	        int newQty = currentQty + p_qty;

	        String updateStockQuery = "UPDATE stock SET s_qty = ? WHERE p_code = ?";
	        PreparedStatement updatePstmt = conn.prepareStatement(updateStockQuery);
	        updatePstmt.setInt(1, newQty);
	        updatePstmt.setInt(2, p_code);
	        updatePstmt.executeUpdate();
	        updatePstmt.close();
	    } else {
	        String insertStockQuery = "INSERT INTO stock (p_code, s_qty) VALUES (?, ?)";
	        PreparedStatement insertPstmt = conn.prepareStatement(insertStockQuery);
	        insertPstmt.setInt(1, p_code);
	        insertPstmt.setInt(2, p_qty);
	        insertPstmt.executeUpdate();
	        insertPstmt.close();
	    }

	    rs.close();
	    pstmt.close();
	    conn.close();
	    System.out.println("매입 등록 및 재고 업데이트 완료!");
	}

	// 데이터 수정 update

	public void update() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		String query = "UPDATE p_ledger SET p_cost = ? WHERE p_date = ?";
		Connection conn = Dbcon.connect();

		PreparedStatement pstmt = conn.prepareStatement(query);
		
		p_cost = sc.nextInt();
		sc.nextLine();
		
		p_date = sc.nextLine();
		
		pstmt.setInt(1, p_cost);
		pstmt.setString(2, p_date);
		

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
		
		p_date = sc.nextLine();
		
		pstmt.setString(1, p_date);
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
		String query = "SELECT * FROM p_ledger";
		// 쿼리 실행(Statement)
		PreparedStatement pstmt = conn.prepareStatement(query);

		ResultSet rs = pstmt.executeQuery();// excute 실행하다

		ArrayList<P_ledgerDAO> list = new ArrayList<>();
		// db 로부터 받은 데이터 받기(ResultSet)

		while (rs.next()) {
			P_ledgerDAO p = new P_ledgerDAO();
			
			p.setP_code(rs.getInt("p_code"));
			p.setC_code(rs.getInt("c_code"));
			p.setP_qty(rs.getInt("p_qty"));
			p.setP_cost(rs.getInt("p_cost"));
			p.setP_date(rs.getString("P_date"));
		
			list.add(p);
			
			}
		
		for(P_ledgerDAO a : list) {
				System.out.println(a);
			
		}
		
	}
}
