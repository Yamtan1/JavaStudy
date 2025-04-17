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
public class StaffDAO {
	
	private int staff_no;
	private String staff_dept;
	private String staff_name;
	private String staff_gender;
	
	// DB에 입력 insert
	public void insert() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		Connection conn = Dbcon.connect();;

		String query = "INSERT INTO staff (staff_no, staff_dept, staff_name, staff_gender ) VALUES (?, ?, ?, ?)";

		staff_no = sc.nextInt();
		sc.nextLine();
		
		staff_dept = sc.nextLine();
		
		staff_name = sc.nextLine();
		staff_gender = sc.nextLine();
		
		PreparedStatement pstmt = conn.prepareStatement(query);

		pstmt.setInt(1, staff_no);
		pstmt.setString(2, staff_dept);
		pstmt.setString(3, staff_name);
		pstmt.setString(4, staff_gender);
		

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	// 데이터 수정 update

	public void update() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		String query = "UPDATE staff SET staff_name = ?, staff_dept = ? WHERE staff_no = ?";
		Connection conn = Dbcon.connect();

		PreparedStatement pstmt = conn.prepareStatement(query);
		
		staff_name = sc.nextLine();
		staff_dept = sc.nextLine();
		staff_no = sc.nextInt();
		sc.nextLine();
		
		
		pstmt.setString(1, staff_name);
		pstmt.setString(2, staff_dept);
		pstmt.setInt(3, staff_no);

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	// 데이터 삭제 delete

	public void delete() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		String query = "DELETE staff WHERE staff_no = ?";

		Connection conn = Dbcon.connect();

		PreparedStatement pstmt = conn.prepareStatement(query);
		
		staff_no = sc.nextInt();
		sc.nextLine();
		
		pstmt.setInt(1, staff_no);
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
		String query = "SELECT * FROM staff";
		// 쿼리 실행(Statement)
		PreparedStatement pstmt = conn.prepareStatement(query);

		ResultSet rs = pstmt.executeQuery();// excute 실행하다

		ArrayList<StaffDAO> list = new ArrayList<>();
		// db 로부터 받은 데이터 받기(ResultSet)

		while (rs.next()) {
			StaffDAO s = new StaffDAO();
			s.setStaff_no(rs.getInt("staff_no"));
			s.setStaff_dept(rs.getString("staff_dept"));
			s.setStaff_name(rs.getString("staff_name"));
			s.setStaff_gender(rs.getString("staff_gender"));
		
			list.add(s);
			
			}
		
		for(StaffDAO a : list) {
				System.out.println(a);
			
		}
		
	}

}
