package Study0324;

public class Atest {

	public static void main(String[] args) {
		
		A a = new A(); // 오른쪽 A가 생성자
		 // 인스턴스는 계속 변경할 수 있따.
		a.s = "Hello";   // A에 있는 인스턴스를 사용하기 위해 a. 을 붙여야 사용가능함.
		int result = a.f2();
		System.out.println(result);
		a.n = 5;
		System.out.println(a.f2());
		

	}

}
