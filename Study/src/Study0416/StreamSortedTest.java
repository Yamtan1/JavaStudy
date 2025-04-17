package Study0416;

import java.util.Arrays;
import java.util.List;

public class StreamSortedTest {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("홍길동","멀린","해리포터");
		
		list.stream() //스트림생성
			.sorted() // 정렬(중간연산)
			.forEach(n -> System.out.println(n + "\t"));//요소를 하나씩 꺼내서 소비함.(최종연산)
		
		list.stream()
			.sorted((s1, s2) -> s2.length() - s1.length())
			.forEach(n -> System.out.println(n + "\t"));

	}

}
