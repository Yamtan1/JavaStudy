package Study0418;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("홍길동", "전우치", "손오공", "해리포터");
		
		String name = list.stream()
					  .reduce("이순신", (s1, s2) -> s1.length() >= s2.length() ? s1:s2); // "이순신" 초기 기준값 설정
						//s1, s2의 길이를 비교해서 s1이 크거나 같으면 s1을반환 아니면 s2를 반환
						// 삼항 연산자(if ~else)
						// 조건 ? 참 : 거짓
		System.out.println(name);
	}
}
