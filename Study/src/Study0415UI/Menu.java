package Study0415UI;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);
	public void start(BookDAO b, Dbcon d) throws SQLException {
		System.out.println("==========도서 정보 관리 시스템==========");
		System.out.println("진행할 메뉴를 선택해주세요");
		System.out.println("[ 1번 도서조회, 2번 도서입력, 3번 도서삭제, 4번 도서수정 ]");
		int input = sc.nextInt();
		if(input == 1) {
			System.out.println("1번 도서 전체 조회 / 2번 도서 검색");	
			int input2 = sc.nextInt();
			sc.nextLine();
			if(input2 == 1) {
				System.out.println("전체 도서목록");
				b.select(d.getStmt());
			}
			else if(input2 == 2) {
				Book book = new Book();
				System.out.println("검색할 도서를 입력해주세요");
				book.setBookname(sc.nextLine());
				b.selectSearch(d.getStmt(), book);
				System.out.println("입력 도서 조회 완료");
			}
		}
		else if(input ==2) {
			Book book = new Book();
			System.out.println("도서정보를 입력합니다");
			System.out.println("도서번호를 입력해주세요 >>> ");
			book.setBookno(sc.nextInt());
			sc.nextLine();
			System.out.println("도서이름을 입력해주세요 >>> ");
			book.setBookname(sc.nextLine());
			System.out.println("저자를 입력해주세요 >>> ");
			book.setWritter(sc.nextLine());
			System.out.println("출판사를 입력해주세요 >>> ");
			book.setPub(sc.nextLine());
			System.out.println("가격을 입력해주세요 >>> ");
			book.setPrice(sc.nextInt());
			System.out.println("도서입력이 완료되었습니다.");
			b.insert(d.getStmt(), book);
			
		}
		else if(input ==3) {
			Book book = new Book();
			System.out.println("삭제할 도서번호를 입력해주세요");
			book.setBookno(sc.nextInt());
			b.delete(d.getStmt(), book);
			System.out.println("도서가 삭제 되었습니다");
		}
		else if(input ==4) {
			Book book = new Book();
			System.out.println("정보수정을 원하는 도서번호를 입력하세요");
			book.setBookno(sc.nextInt());  
			sc.nextLine();
			System.out.println("수정할 도서 이름을 입력해주세요");
			book.setBookname(sc.nextLine());
			System.out.println("수정할 저자를 입력해주세요");
			book.setWritter(sc.nextLine());
			System.out.println("수정할 출판사를 입력해주세요");
			book.setPub(sc.nextLine());
			System.out.println("수정할 가격을 입력해주세요");
			book.setPrice(sc.nextInt());
			b.update(d.getStmt(),book);
			System.out.println("도서 수정이 완료 되었습니다");
		}
		
	}
}
