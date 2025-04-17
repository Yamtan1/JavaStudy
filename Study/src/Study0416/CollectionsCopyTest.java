package Study0416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsCopyTest {

	public static void main(String[] args) {
		
		List<String> src = Arrays.asList("홍길동", "전우치", "손오공", "멀린");// 원래는 불변 Imutable(변경불가능한) 객체 생성
		
		//수정 가능한 리스트로 생성
		List<String> dst = new ArrayList<>(src); // Mutable(변경가능한) 객체로 재생성
		System.out.println(dst);
		//정렬 수행
		Collections.sort(dst);
		System.out.println(dst);
		// 다시 정렬 이전 상태로 돌아갈 필요가 생겼다.
		Collections.copy(dst, src); // 오른쪽에 있는걸 왼쪽에 넣는다
		System.out.println(dst);
		//수정가능한 상태인지 확인.(Mutable 삭제)
		dst.remove(0);
		System.out.println(dst);
	}

}
