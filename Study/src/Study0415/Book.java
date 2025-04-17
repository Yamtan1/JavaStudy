package Study0415;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class Book {

	private int bookno;
	private String bookname;
	private String writter;
	private String pub;
	private int price;
	private static List<Book> list = new ArrayList<>();
	
	public static void addBook(Book b) {
		list.add(b);
	}
	public static List<Book> getBookList() {
		return list;
	}
	 public static void clearBooks() {
	        list.clear();
	    }
}

