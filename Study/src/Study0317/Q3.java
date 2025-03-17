package Study0317;

public class Q3 {

	public static void main(String[] args) {
		// 짝수와 홀수를 판별하는 함수 정수가 주어지면
		// 짝수면 0 홀수면 1을 반환함
		// 메인함수는 짝수 홀수 함수를 호출해서 숫자를 넣고
		// 그함수는 0 1을 반환해줄텐데 0이면짝수입니다 1이면 홀수입니다를 출력하는 함수를 작성
		int x = f1(6);
		if(x == 0) {
			System.out.println("짝수입니다.");
		}
		else {
			System.out.println("홀수입니다.");
		}
	}
	public static int f1(int n) {
		if(n % 2 == 0) {
			return 0;
		}
		else {
			return 1;
		}
	/*	int result = n % 2;  <<내가 한 방법
		return result; */
	}

}
