package Study0408;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member m1 = new Member("aaa123", "aaa1234","홍길동");
		Member m2 = new Member("qwer", "qwer1234","김미자");
		Member m3 = new Member("asdf", "asdf1234","김옥자");
		
		ArrayList<Member> mList = new ArrayList<>();
		mList.add(m1);
		mList.add(m2);
		mList.add(m3);
		
		boolean flag = true;
		while(flag) {
			System.out.println("아이디를 입력하세요");
			String id = sc.nextLine();
			System.out.println("비밀번호를 입력하세요");
			String pw = sc.nextLine();
			
			for(Member z : mList) {
				if(id.equals(z.getId()) && pw.equals(z.getPw()) ){
					System.out.println("로그인 되었습니다");
					flag=false;
					break;
				}
				else {
					System.out.println("아이디 비밀번호를 다시 한 번 확인해주세요");
					break;
				}
			}
		}
		
	}

}
