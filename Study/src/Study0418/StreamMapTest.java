package Study0418;
import java.util.Arrays;
import java.util.List;

public class StreamMapTest {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("apple", "anana", "orange");
		
		//a로 시작하는 단어 첫글자 대문자 변환 후 출력
		list.stream()
			.filter(s -> s.charAt(0) == 'a') 
			.map(s -> s.toUpperCase()) // 대문자로 변환
			.filter(s -> s.startsWith("A"))
			.forEach(n -> System.out.println(n));
		
		
		//e로 끝나는 단어 대문자로 변환 후 출력
		list.stream()
			.map(s -> s.toUpperCase())
			.filter(s -> s.endsWith("E"))
			.forEach(n -> System.out.println(n));
		
		list.stream()
			.filter(s -> s.startsWith("a"))
			.filter(s -> s.endsWith("e"))
			.map(s -> s.toUpperCase()) // 대문자로 변환
			.forEach(n -> System.out.println(n));
		/* stream
		자료의 흐름

		데이터뭉치(콜렉션자료)

		- 중간연산
		filter : 조건에 맞는 자료들로 추출하기
		map: 자료를 특정한 형태로 변환하기(예: 문자열 --> 문자열의 길이)
		sorted() 정렬
		distict: 중복 제거
		limit() : 스트림 범위 제한
		skip() : 스트림 내 데이터들 중 앞에서 n개 요소 건너 뜀
		
		-- 최종연산
		collect() : 콜렉션자료 만들어 반환
		forEach() : 각 요소에 대한 작업 수행
		count() : 요소 개수 반환
		reduce() : 요소를을 하나의 결과로 만들기
		anyMatch(), allMatch() : 조건 검사
		
		--삼항 연산자(if ~else)
		조건 ? 참 : 거짓
		*/	
		

	}
}
