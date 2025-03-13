package Study0313;

public class Con0313 {

	public static void main(String[] args) {
		
		int[] A = {2,4,16,4,50,6,7,8,9,10};
		int sum = 0;
		// A배열의 길이는 10이다. A배열의 인덱스 값의 범우 : 0 ~ 9이다
		// 반복문 제어변수는 초기값을 0으로 하고, 배열의 길이만큼 반복한다
		// 반복문 제어변수의 값의 범위는 0 ~ 9
		// 짝수 인덱스의 값을 더 하기
		for(int i = 0 ; i < 10 ; i ++) {
			if(i % 2 == 1) {
				continue;
			}
			else {
				sum = sum + A[i];
			}
		}
		System.out.println(sum);
	}
}