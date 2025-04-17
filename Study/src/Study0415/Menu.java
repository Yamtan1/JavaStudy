package Study0415;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);
	public void start(BookDAO b, Dbcon d) throws SQLException {
		System.out.println("프로그램을 실행합니다");
		System.out.println("진행할 메뉴를 선택해주세요");
		System.out.println("[ 1번 도서조회, 2번 도서입력, 3번 도서삭제, 4번 도서수정 ]");
		int input = sc.nextInt();
		if(input == 1) {
			System.out.println("전체 도서목록");
			b.select(d.getStmt());
		}
		else if(input ==2) {
			b.insert(d.getStmt());
		}
		else if(input ==3) {
			b.delete(d.getStmt());
		}
		else if(input ==4) {
			b.update(d.getStmt());
		}
		
	}
}
