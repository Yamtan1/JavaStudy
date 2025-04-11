package MemberPack0411;

import java.util.ArrayList;
import java.util.List;

public class Member {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private char grade;
	private static List<Member> memberList = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public static List<Member> getMemberList() {
		return memberList;
	}

	// 멤버를 추가하는 메서드
	public static void addMember(Member m) {
		memberList.add(m);
	}

	
	
	@Override
	public String toString() {
		return "VALUES (" + getId() + "," + getName() + "," + getPhone() + "," + getPw() + "," + getGrade() + ")";
	}
	
	

}
