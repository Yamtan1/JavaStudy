package Study0324;

public class Calculator {
	//변수가 2개있음.
	//정수를 담을수 있는 변수 2개
	//사칙연산을 하는 기능을 메서드 들이 있음. 멤버변수들을 가지고 사칙연산 진행
	//int n1;
	//int n2;
	
	int sum(int n, int m) {
		int sum = n + m;
		return sum;
	}
	int sub(int n, int m) {
		int sub = n - m;
		return sub;
	}
	int mul(int n, int m) {
		int mul = n * m;
		return mul;
	}
	double div(int n, int m) {
		double div = (double)n / m;
		return div;
	}
}
