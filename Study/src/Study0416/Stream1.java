package Study0416;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream1 {
	//스트림 변수는 기존 자료를 변경하지 않는다
	//한번 사용하고 난 스트림은 재사용 할 수 없다
	public static void main(String[] args) {
		int[]arr = {1, 2, 3, 4, 5};
		
		//1. 스트림 생성
		IntStream stm1 = Arrays.stream(arr);
		
		//2. 중간 연산
		IntStream stm2 = stm1.filter(n -> n%2 == 1); //홀수인 애들만 전달함
		
		//3. 최종 연산
		int sum = stm2.sum();
		
		System.out.println(sum);
		
		int sum2 = Arrays.stream(arr)
						.filter(n -> n%2 == 0)//메서드 체이닝
						.sum(); //메서드 체이닝
		System.out.println(sum2);
	}

}
