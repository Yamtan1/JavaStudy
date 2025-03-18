package Study0318;

public class Q20318 {

	public static void main(String[] args) {
	/* 	// 어떤 함수에서 일어난 일이 다른 함수에서 영향을 줄 수 있는 것은 return 밖에 없다.
		int n1 = 5;
		int n2 = 3;
		System.out.printf("f함수 실행전 : %d, %d\n", n1, n2);
		f(n1, n2);
		System.out.printf("f함수 실행후 : %d, %d\n", n1, n2);
	}
	static void f(int x, int y) { //x 와 y 의 값을 변경하는 함수
		int temp = x;
		x = y;
		y = temp; */
		int[] A = new int[2];
		A[0] = 5;
		A[1] = 3;
		
		System.out.printf("f1함수 실행전 : %d, %d\n", A[0], A[1]);
		f1(A);
		System.out.printf("f1함수 실행후 : %d, %d\n", A[0], A[1]);
	}
	static void f1(int[] x) { //일반 자료형일 경우 void함수는 영향을 줄 수 없지만 참조자료형일 경우 가능함.
		int temp = x[0];		// 변수 공간에 주소를 저장하고 있는 것을 참조 자료형이라고 한다. ex) 배열
		x[0] = x[1];
		x[1] = temp;
	}
	
}