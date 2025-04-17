package Study0416;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("aaa","bbb","ccc");
		
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		for(String s : list) {
			System.out.println(s + "\t");
		}
		System.out.println();
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next() + "\t");
		}
	}

}
