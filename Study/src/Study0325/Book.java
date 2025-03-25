package Study0325;

public class Book {
	//도서정보 프로그램을 짜려고 한다 클래스이름은 Book
	//멤버변수로는 제목, 장르, 출판사, 가격, 작가 
	//북 클래스의 필수 데이터는 책제목, 저자, 출판사가 필수 데이터 이다. >>생성자 사용
	//각 멤버변수들을 변경하고 반환할 수 있는 함수를 만드세용
	
	String writer;
	String genre;
	String publisher;
	String title;
	int price;
	
	Book(){}
	
	Book(String title, String writer, String publisher){
		this.title=title;
		this.writer=writer;
		this.publisher=publisher;
	}
	Book(String title, String writer, String publisher, String genre, int price){
		this.title=title;
		this.writer=writer;
		this.publisher=publisher;
		this.genre=genre;
		this.price=price;
	}
	
	void setWriter(String x) {
		writer=x;
	}
	void setGenre(String y) {
		genre=y;
	}
	void setPublisher(String z) {
		publisher=z;
	}
	void setTitle(String i) {
		title=i;
	}
	void setPrice(int a) {
		price=a;
	}
	
	String getWriter() {
		return writer;
	}
	String getGenre() {
		return genre;
	}
	String getPublisher() {
		return publisher;
	}
	String getTitle() {
		return title;
	}
	int getPrice() {
		return price;
	}
	//함수를 만드는데 함수의 이름은 bookInfoToString 책정보를 문자열로 반환하는 함수
	//우클릭 소스 제너레이터 투스트링을 통해서도 만들 수 있으나 toString코드로 이름을 설정할 시 메인 함수에서 바로 출력해도 리턴 값이 나오게 됨.
	public String bookinfotoString() { 
		return "Book [writer=" + writer + ", genre=" + genre + ", publisher=" + publisher + ", title=" + title
				+ ", price=" + price + "]";
	}
	
	
}
