package Study0321;

public class param0321 {

	public static void main(String[] args) {
		int n = 1;
		int result = f(n);
		System.out.println(result);

	}
	static int f(int param1) {
		int n = 10;
		int sum = f2(param1, n);
		return sum;
	}
	static int f2(int param1, int param2) {
		int n = 100;
		int b = f3(n, param1, param2);
		return b;
	}
	static int f3(int param1, int param2, int param3) {
		int n = 1000;	
		int a = f4(param1, param2, param3, n);
		return a;
	}
	static int f4(int param1, int param2, int param3, int param4) {
		return param1 + param2 + param3 + param4;
	}
}