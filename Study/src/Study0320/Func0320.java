package Study0320;

public class Func0320 {

	public static void main(String[] args) {
		// n1,n2값을 메인이 전달 calc라는 함수가 있는데 add함수한테 그대로 전달해줄거임
		// sub라는 함수한테 그대로 전달해줄거임 mul, div함수한테도 그대로 전달해줄거임
	   	// add라는 함수는 덧셈을수행 값을 calc한테 전달 sub는 뺄셈 뺄셈결과를 calc한테전달
		// mul은 곱셈 결과돌려줌 div함수도 결과를 돌려줄거임 나눗셈을 했을때 소숫 점이 발생할 수 있기에 실수를 돌려줄거임
		// 4개의 함수에서 나온 결과값들을 다 더해 더한값을 구해서 메인한테 돌려줄거임 메인은 그걸 화면에다 출력 총합의 결과는 정수가 나와야함 홀수인지 짝수인지 판별해서 메인에다가 홀수면은 1 짝수면은 0을 반환하게하고
		// 메인에서는 1이왓으면 홀수입니다 출력
		int n1 = 25;
		int n2 = 11;
		int A =calc(n1, n2);
		int B =oddeven(A);
		if(B == 1) {
			System.out.println("홀수입니다.");
		}
		else if(B == 0 ) {
			System.out.println("짝수입니다.");
		}
	}
	public static int calc(int n, int m) {
		
		int Q = add(n, m);
		System.out.println("합은" + Q);
		int W = sub(n, m);
		System.out.println("빼기는"+ W);
		int E = mul(n, m);
		System.out.println("곱하기는" + E);
		double R = div(n, m);
		System.out.println("나누기는" + R);
		int T =(int)R;
		System.out.println("R을 전환하면" + T);
		int totalnum = Q + W + E + T;
		System.out.println("다 더하면" + totalnum);
		return totalnum;
	}
	public static int add(int a, int b) {
		int sum = a + b;
		return sum;
	}
	public static int sub(int c, int d) {
		int sub = c - d;
		return sub;
	}
	public static int mul(int e, int f) {
		int mul = e * f;
		return mul;
	}
	public static double div(double g, double h) {
		double div = g / h;
		return div;
	}
	public static int oddeven(int x) {
		int y = 0;
		if(x % 2 ==0) {
			y = 0;
		}
		else if(x % 2 == 1) {
			y = 1;
		}
		System.out.println(y);
		return y;
	}
}