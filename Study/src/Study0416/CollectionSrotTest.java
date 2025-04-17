package Study0416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSrotTest {

	public static void main(String[] args) {
		// Comparable 메서드를 구성해야 정렬기능을 사용할 수 있다
		List<String> list = Arrays.asList("횽길동", "전우치", "손오공", "멀린"); //불변 자료형
		
		//list.add("aaa");
		list = new ArrayList<>(list);
		list.add("aaa");
		for(String s : list) {
			System.out.print(s + "\t");
		}
		Collections.sort(list); //오름차순
		System.out.println();
		for(String s : list) {
			System.out.print(s + "\t");
		}
	}	

}
