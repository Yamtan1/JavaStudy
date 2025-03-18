package Study0318;

public class Function0318 {

	public static void main(String[] args) {
		// return 은 값을 무조건 하나만 보낼 수 있다.
		// 메인함수에 정수 두개가 있음
		// f 함수 한테 n1,n2를 넣어줌 f함수는 이 두 수를  앞수에서 뒷수를 더한값 앞수에서 뒷수를 뺀값을 메인함수에 돌려준다.
		// 메인함수에서는 두 수의 합과 차를 출력해준다
		int n1 =20;
		int n2 =20;
		int[] x = f(n1, n2);
		System.out.println("두수의 합은 : " + x[0]);
		System.out.println("두수의 차는 : " + x[1]);
	}
	public static int[] f(int x1, int x2) {
		 int[] arr = new int[2]; 
		 arr[0] = x1 + x2;
		 arr[1] = x1 - x2;
		 return arr;
	}
}
