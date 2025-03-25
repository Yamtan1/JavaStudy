package Study0325;

public class Student {
	
	/*private*/ int no; // 같은패키지에 있어도 사용이 불가능 (private)
	String name;
	char gender;
	
	
	//기본 생성자
	Student(){}
	
	
	// 직접 필요에 따라 만들어 쓰는 생성자
	// 이러한 생성자를 만드는 경우 기본 생성자도 함께 입력해주어야함!
	
	Student(int no, String name){
		this.no = no;
		this.name = name;
	}
	
	Student(int no, String name, char gender){
		this(no, name);
		this.gender =gender;
	}
	/* Student(int no, String name){ //멤버변수와 매개변수를 이름을 똑같이 했을때 맴버변수앞에 this. 라는 글자를 적는다
	this.no = no;				// this 란 > 클래스를 통해 만들어진 인스턴스(멤버변수)
	this.name = name; 
	} */
	
	void setNo(int x){ //Setter 함수 == 멤버변수의 값을 변경시켜주는 함수
		no = x;
	}
	void setName(String str){ //Setter 함수
		name = str;
	}
	void setgender(char gender){ //Setter 함수
		this.gender = gender;
	}
	
	//현재 인스턴스가 가지고 있는 값을 리턴해주는 함수를 만드세요.
	//멤버변수의 값을 외부로 반환하는 것을 Setter 함수 (get)라 한다 
	int getNo() {
		int y = no;
		return y;
	}
	
	String getName() {
		String b = name;
		return b;
	}
	
	char getGender() {
		char c = gender;
		return c;
	}
}
