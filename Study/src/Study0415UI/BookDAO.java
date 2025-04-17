package Study0415UIver;

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
	
	
		public void insert(Statement stmt, Book b) throws SQLException { //INSERT
		this.stmt = stmt;
		super.addBook(b);
		String query = "INSERT INTO bookinfo VALUES ("  
				+ b.getBookno() +","+	
				"'" + b.getBookname() +"'"+","+
				"'" + b.getWritter() +"'"+","+
				"'" + b.getPub() +"'"+","+
				b.getPrice() + ")";
		
		int result = stmt.executeUpdate(query);
	}
		public void delete(Statement stmt, Book b) throws SQLException {
			this.stmt = stmt;
			String query = "DELETE FROM bookinfo WHERE bookno = " + b.getBookno();
			stmt.executeUpdate(query);
		}
		
		
		public void select(Statement stmt) throws SQLException{ //SELECT
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
		
		
		public void update(Statement stmt, Book b) throws SQLException{ //UPDATE
			this.stmt = stmt;
			String query = "UPDATE bookinfo SET bookname =" + 
			"'" + b.getBookname() + "'"+ "," + "writter = " +
			"'" + b.getWritter() + "'"+ "," + "pub = " +
			"'" + b.getPub() + "'"+ "," + "price = " +
			b.getPrice() + " WHERE bookno =" + b.getBookno();
			int result = stmt.executeUpdate(query);
		}
		
		
		public void selectSearch(Statement stmt, Book b) throws SQLException { //SELECT 선택조회
			Book.clearBooks();
			this.stmt = stmt;
			String query = "SELECT bookname FROM bookinfo WHERE bookname LIKE '" + "%" + b.getBookname() + "%" + "'";
			ResultSet rs = stmt.executeQuery(query); 
			
			while(rs.next()) {
				Book book = new Book(); 
				String bookname = rs.getString("bookname");
			
				book.setBookno(book.getBookno());
				book.setBookname(bookname);
				book.setWritter(book.getWritter());
				book.setPub(book.getPub());
				book.setPrice(book.getPrice());
		
				Book.addBook(book);
			}
			
	        for (Book b1 : Book.getBookList()) {
	            System.out.println(b1);
	        }
		}
		
}
