package productDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import productVo.orderListVo;
import productVo.orderVo;
import productVo.product;
import productVo.shopRegi;

 	

public class productDao {

	protected static Connection conn;
	
	public void insert (orderVo order) throws ClassNotFoundException, SQLException {
		conn = Dbcon.connect();
		
		String query = "INSERT INTO tbl_order_202101 VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, order.getOrderno());
		pstmt.setString(2, order.getShopno());
		pstmt.setString(3, order.getOrderdate());
		pstmt.setString(4, order.getPcode());
		pstmt.setString(5, order.getAmount());
		
		pstmt.executeUpdate();
	}
	
	public List<orderListVo> select() throws ClassNotFoundException, SQLException{
		conn = Dbcon.connect();  // DB 연결 확인

	    // 쿼리문 작성
	    String query = "SELECT s.shopno AS 할인점코드, s.shopname AS 점포명, " +
	                   "LPAD(SUBSTR(o.orderno, 1, 4), 4, '0') || '-' || LPAD(SUBSTR(o.orderno, 5), 4, '0') AS 주문번호, " +
	                   "TO_CHAR(TO_DATE(o.orderdate, 'YYYYMMDD'), 'YYYY-MM-DD') AS 주문일자, " +
	                   "p.pcode AS 제품코드, p.pname AS 제품명, o.amount AS 주문수량, " +
	                   "TO_CHAR(p.cost, '9,999,999') AS 단가, " +
	                   "TO_CHAR(p.cost * o.amount, '9,999,999') AS 소비자가격, " + 
	                   "TO_CHAR(p.cost * o.amount - (p.cost* o.amount * s.discount / 100), '9,999,999') AS 할인가격 " +
	                   "FROM tbl_order_202101 o " +
	                   "JOIN tbl_product_202101 p ON o.pcode = p.pcode " +
	                   "JOIN tbl_shop_202101 s ON o.shopno = s.shopno ORDER BY 주문일자";
	    
	    // 쿼리 실행
	    PreparedStatement pstmt = conn.prepareStatement(query);
	    ResultSet rs = pstmt.executeQuery();
	    
	    List<orderListVo> list = new ArrayList<>();
	    
	    // ResultSet을 순차적으로 확인
	    while (rs.next()) {
	        orderListVo order = new orderListVo();
	        
	        // 디버깅용 로그 추가
	        System.out.println("리스트 생성 시작");

	        // 각 컬럼 값 할당
	        order.setShopno(rs.getString("할인점코드"));
	        order.setShopname(rs.getString("점포명"));
	        order.setOrderno(rs.getString("주문번호"));
	        order.setOrderdate(rs.getString("주문일자"));
	        order.setPcode(rs.getString("제품코드"));
	        order.setPname(rs.getString("제품명"));
	        order.setAmount(rs.getString("주문수량"));
	        order.setCost(rs.getString("단가"));
	        order.setOriginalPrice(rs.getString("소비자가격"));
	        order.setDiscountPrice(rs.getString("할인가격"));
	        
	        // 디버깅용 로그 추가
	        System.out.println("리스트에 항목 추가됨: " + order.getShopno() + ", " + order.getShopname());
	        
	        list.add(order);
	    }
	    
	    // 만약 리스트에 항목이 없으면 출력
	    if (list.isEmpty()) {
	        System.out.println("No orders found.");
	    } else {
	        System.out.println("Total orders found: " + list.size());
	    }

	    // 리소스 정리
	    rs.close();
	    pstmt.close();
	    conn.close();

	    return list; 
	}
	
	public List<shopRegi> shopRegiDate() throws ClassNotFoundException, SQLException{
		
		conn = Dbcon.connect();
		
		String query = "SELECT s.shopno AS 할인점코드, p.pcode AS 제품코드, p.pname AS 제품명, SUM(o.amount) AS 주문총수량"
				+ " FROM tbl_shop_202101 s "
				+ "JOIN  tbl_order_202101 o ON s.shopno = o.shopno "
				+ "JOIN  tbl_product_202101 p ON o.pcode = p.pcode "
				+ "GROUP BY s.shopno, p.pcode, p.pname "
				+ "ORDER BY s.shopno";
		PreparedStatement pstmt = conn.prepareStatement(query);
	    ResultSet rs = pstmt.executeQuery();
	    
	    List<shopRegi> list = new ArrayList<>();
	    
	    while (rs.next()) {
	        shopRegi s = new shopRegi();
	        s.setShopno(rs.getString("할인점코드"));
	        s.setPcode(rs.getString("제품코드"));
	        s.setPname(rs.getString("제품명"));
	        s.setAmount(rs.getString("주문총수량"));
	        list.add(s);
	    }
	    return list;
	}
	
	public List<product> productInfo() throws ClassNotFoundException, SQLException{
		
		conn = Dbcon.connect();
		
		String query = "SELECT pcode AS 제품코드, pname AS 제품명, cost AS 단가, \r\n"
				+ "TO_CHAR(cost - (cost*0.1) , '9,999,999') AS 할인10, \r\n"
				+ "TO_CHAR(cost - (cost * 0.15), '9,999,999') AS 할인15\r\n"
				+ "FROM tbl_product_202101\r\n"
				+ "ORDER BY pcode";
				
		PreparedStatement pstmt = conn.prepareStatement(query);
	    ResultSet rs = pstmt.executeQuery();
	    
	    List<product> list = new ArrayList<>();
	    
	    while (rs.next()) {
	    	product p = new product();
	    	p.setPcode(rs.getString("제품코드"));
	    	p.setPname(rs.getString("제품명"));
	    	p.setCost(rs.getString("단가"));
	    	p.setDiscount10(rs.getString("할인10"));
	    	p.setDiscount15(rs.getString("할인15"));
	    	
	        list.add(p);
	    }
	    return list;
	}
	
}
