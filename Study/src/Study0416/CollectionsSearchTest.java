package Study0416;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSearchTest {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		list.add("홍길동");
		list.add("전우치");
		list.add("손오공");
		
		Collections.sort(list); // 오름차순 정렬 
		
		int idx1 = Collections.binarySearch(list, "홍길동"); //몇번째에 위치하는지 알려줌 음수가 나오면 없는 데이터 라는뜻
		System.out.println(idx1);
		
		if(idx1 == -1) {
			System.out.println("해당 데이터는 리스트에 없습니다");
		}
		else {
			System.out.println("해당데이터는 리스트의" + idx1 + "번 인덱스에 있습니다");
		}
	}
}

