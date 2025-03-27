package Study0327;

public class AAA {
	
	int n;
	static int x;
	static int y;
	
	
	void test() {
		System.out.println("test 입니다....");
	}
	
	void nonStaticf() {
		test();
		staticF();
		System.out.println("f함수 실행....." + y);
	}
	
	static void staticF() {
		//test();  사용안됨
		//nonStaticF(); 사용안됨
		System.out.println("static f함수 실행....." + x);
	}
}
