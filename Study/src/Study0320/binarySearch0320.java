package Study0320;

public class binarySearch0320 {

	public static void main(String[] args) {
		// 이분검색, 이진검색은 반드시 순서가 정렬 되어 있어야한다.
		// 메인에 정수를 담을 n이라는 애가 있음. m도있음 k도있음
		// 이 변수 3개를 f라는 함수한테 전달해준다.
		// f함수는 이 값을 가지고 그값 3개를 배열에다가 담을거임. 배열의 이름은 A임
		// n이 0번째 m이 1번째 k가 2번째 인덱스
		// f함수는 이 배열에 들어가 있는 합을 구할거임 sum이라는 변수에다가
		// sum값을 다시 메인한테 전달 해줄거임 그 후 sum이라는 공간에 넣을 거임.
		// 메인에서는 마지막으로 sum을 출력할거임.
		// 2번째 메인함수는 또 다른 일을 하려고함 G라는 함수한테 일을 시킬거임
		// f함수로 받은 sum값을 G한테 전달해줄거임 그러면 G함수는 그 값을 받아서
		// 걔를 3으로 나눌거임 G라고하는 함수는 메인함수한테 나눈 3의 몫과 나머지를 보내줄거임
		// 메인함수는 몫과 나머지를 출력할거임 (몫은 몇 나머지는 몇 입니다)
		int n = 25;
		int m = 46;
		int k = 30;
				
		int sum = f(n,m,k);
		System.out.println(sum);
		int[] l = G(sum);
		System.out.println("몫은 : " + l[0] + "나머지는 : " + l[1]);
		
	}
	public static int f(int x, int y, int z) {
		int[] A = new int[3]; //
		int sum = 0;
		for(int a = 0 ; a < A.length ; a++) {
			if(a == 0) {
				A[a] = x;
			}
			if(a == 1) {
				A[a] = y;
			}
			if(a == 2) {
				A[a] = z;
			}
			sum = sum + A[a];
		}
		return sum;
	}
	public static int[] G(int c) {
		int [] div = new int[2];
		div[0] = c / 3;
		div[1] = c % 3;
		return div;
	}
	
	/* public static int f(int... values) {  //이런 코드도 있다 
		int[] A = new int[3];
		int sum = 0;
		for(int a = 0 ; a < A.length ; a++) {
			A[a] = values[a];
			sum = sum + A[a];
		}
		return sum;
	} */
}
	