package Study0415;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Data
public class BookDAO extends Book {
	Scanner sc = new Scanner(System.in);
	private Statement stmt;	
	
	
		public void insert(Statement stmt) throws SQLException {
		this.stmt = stmt;
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
		
		super.addBook(book);
		
		String query = "INSERT INTO bookinfo VALUES ("  
				+ book.getBookno() +","+	
				"'" + book.getBookname() +"'"+","+
				"'" + book.getWritter() +"'"+","+
				"'" + book.getPub() +"'"+","+
				book.getPrice() + ")";
		
		int result = stmt.executeUpdate(query);
		if(result == 1) {
			System.out.println("저장되었습니다");
		}
		else {
			System.out.println("저장에실패하였습니다");
		}
	}
		public void delete(Statement stmt) throws SQLException {
			this.stmt = stmt;
			System.out.println("삭제할 도서번호를 입력해주세요");
			int input = sc.nextInt();
			String query = "DELETE FROM bookinfo WHERE bookno = " + input;
			stmt.executeUpdate(query);
			System.out.println("게시글이 삭제 되었습니다");
		}
		
		public void select(Statement stmt) throws SQLException{
			Book.clearBooks();
			this.stmt = stmt;
			String query = "SELECT * FROM bookinfo";
			ResultSet rs = stmt.executeQuery(query); 
			
			while(rs.next()) {
				Book book = new Book();
				int bookno = rs.getInt("bookno"); 
				String bookname = rs.getString("bookname");
				String writter = rs.getString("writter");
				String pub = rs.getString("pub");
				int price = rs.getInt("price");
				
				book.setBookno(bookno);
				book.setBookname(bookname);
				book.setWritter(writter);
				book.setPub(pub);
				book.setPrice(price);
						
				Book.addBook(book);
			}
			
	        for (Book b1 : Book.getBookList()) {
	            System.out.println(b1);
	        }
		}
		public void update(Statement stmt) throws SQLException{
			this.stmt = stmt;
			System.out.println("정보수정을 원하는 도서번호를 입력하세요");
			int input5 = sc.nextInt();
			sc.nextLine();
			System.out.println("수정할 도서 이름을 입력해주세요");
			String input1 = sc.nextLine();
			System.out.println("수정할 저자를 입력해주세요");
			String input2 = sc.nextLine();
			System.out.println("수정할 출판사를 입력해주세요");
			String input3 = sc.nextLine();
			System.out.println("수정할 가격을 입력해주세요");
			int input4 = sc.nextInt();
			
			String query = "UPDATE bookinfo SET bookname =" + 
			"'" + input1 + "'"+ "," + "writter = " +
			"'" + input2 + "'"+ "," + "pub = " +
			"'" + input3 + "'"+ "," + "price = " +
			input4 + " WHERE bookno =" + input5;
			int result = stmt.executeUpdate(query);
		}
}
