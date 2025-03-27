package Study0327;

public class StaticTest {

	public static void main(String[] args) {
		
		//AAA a = new AAA();
		//a.n = 10;
		//System.out.println(a.n);
		//참조변수를 통해서 접근하면 인스턴스 변수임.
		
		//a.x=20;
		AAA.x = 30; //인스턴스 없이 클래스 이름만으로도 사용가능
		//System.out.println(a.x);
		System.out.println(AAA.x);
		
		AAA a1 = new AAA();
		AAA a2 = new AAA();
		System.out.println(a1.x);
		System.out.println(a2.x);
		
		a1.x=100;
		System.out.println(a1.x);
		System.out.println(a2.x);
	}

}
