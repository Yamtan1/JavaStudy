package Study0325;

public class BookTest {

	public static void main(String[] args) {
		Book info = new Book("책이름","작가","출판사","장르",10000);	
		Book info2 = new Book("아아아","홍길동","아무데나");
		String x = info.bookinfotoString();
		System.out.println(x);
	}
}