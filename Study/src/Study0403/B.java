package Study0403;

public class B implements IB { // 클래스 B는 IB인터페이스의 구현체 입니다 라고 읽어야함.

	@Override
	public void f1() {
		System.out.println("B클래스의 f1 함수 실행");
		
	}

	@Override
	public int f2() {
		System.out.println("B클래스의 f2 함수 실행");
		return 0;
	}
	

}
