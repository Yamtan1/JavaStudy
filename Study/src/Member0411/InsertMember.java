package MemberPack0411;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertMember extends DbCon {
	
	Scanner sc = new Scanner(System.in);
	private Statement stmt;
	
	public InsertMember(Statement stmt) {
		this.stmt = stmt;
	}
	public void insertMem(Member m) throws SQLException, ClassNotFoundException {
		System.out.println("회원가입 진행");
		
		System.out.println("가입할 아이디를 입력해주세요");
		m.setId(sc.nextLine());  
		System.out.println("비밀번호를 입력해주세요");
		m.setPw(sc.nextLine());
		System.out.println("연락처를 입력해주세요");
		m.setPhone(sc.nextLine());
		System.out.println("이름을 입력해주세요");
		m.setName(sc.nextLine());
		System.out.println("등급을 입력해주세요");
		String temp = sc.nextLine();
		m.setGrade(temp.charAt(0));
		System.out.println("회원가입이 완료 되었습니다.");
		Member.addMember(m);
		String query = "INSERT INTO tbl_member VALUES (" + 
				"'" + m.getId() +"'"+","+
				"'" + m.getName() +"'"+","+
				"'" + m.getPhone() +"'"+","+
				"'" + m.getPw() +"'"+","+
				"'" + m.getGrade() +"'"+")";
				
		 int result = stmt.executeUpdate(query); 
		//System.out.println("result" + result); 잘적용 되었는지 확인
		 
	}
	
}
