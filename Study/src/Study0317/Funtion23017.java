package Study0317;

public class Funtion23017 {

	public static void main(String[] args) {
		// 함수의 이름은 f1 
		// 반환자료형이 없음 void
		// 입력자료가 없음
		// 실핼문은 f1함수 실행....
		f1();
		f2(32);
		int x = f3(3);
		System.out.println(x);
		int a = sum(1,2);
		int b = subtraction(4,3);
		int c = multi(10,2);
		double d = division(4,3);
		System.out.println(a + " " + b + " " + c + " " + d);
	}
	public static void f1() {
		System.out.println("f1 함수 실행중");
		return;
	}
	//함수이름이 f2
	//반환자료는 없음
	//입력자료는 임의의 정수를 하나 받을거임
	//실행코드는 출력문 입력된 자료를 그대로 출력하는 코드
	public static void f2(int n) {
		System.out.println(n);
	}
	public static int f3(int n) {
		int result = n + 5;
		return result;
	}
	public static int sum(int i, int i2) {
		return i + i2;
	}
	public static int subtraction(int i, int i2) {
		return i - i2;
		
	}
	public static int multi(int i, int i2) {
		return i * i2;
		
	}
	public static double division(int i, int i2) {
		return (double)i / i2; 
		
	}
}