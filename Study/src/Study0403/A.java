package Study0403;

public class A extends AbstractParent {

	public A(int n){
		super(n);
		System.out.println("자식 A클래스 생성자 호출");
	}
	
	@Override
	public void af() {
		System.out.println("오버라이드된 af()함수 실행...");
		
	}
	
}
