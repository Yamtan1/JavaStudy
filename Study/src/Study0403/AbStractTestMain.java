package Study0403;

public class AbStractTestMain {

	public static void main(String[] args) {
		
		//AbstractParent ap = new AbstractParent(); // 추상클래스는 인스턴스 생성이 안됨.
		A a = new A(100); //자식 생성자가 인스턴스를 생성할 때는 작동은 함.
		AbstractParent a1 = new A(15);
		System.out.println(a.getN());
		
		
		
	}

}
