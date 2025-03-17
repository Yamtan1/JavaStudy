package Study0317;

public class Calculator0317 {

	public static void main(String[] args) {
		// 메인함수는 두개의 정수를 넣어줄거임
		// 곱셈 뺄셈 나눗셈 덧셈 을 다 해주고 결과를 출력
		// 메인한테 돌려주는게 아니라 화면에다가 그대로 출력
		// 출력하고나면 메인함수는 프로그램을 종료합니다 하고 프로그램을 종료
		calculator(8,3);
		System.out.println("프로그램을 종료합니다.");
	}
	public static void calculator(int n, int n2) {
		int a = sum(n, n2);
		int b = sub(n, n2);
		int c = mul(n, n2);
		double d = div(n, n2);
		System.out.println("덧셈 : " + a + " 뺄셈 : " + b + " 곱셈 : " + c + " 나눗셈 : " + d);
	}
	public static int sum(int i, int i2) {
		return i + i2;
	}
	public static int sub(int i, int i2) {
		return i - i2;
		
	}
	public static int mul(int i, int i2) {
		return i * i2;
		
	}
	public static double div(int i, int i2) {
		return (double)i / i2; 
	}

}
