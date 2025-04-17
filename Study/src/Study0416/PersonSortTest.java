package Study0416;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonSortTest {

	public static void main(String[] args) {
		
		Person p1 = new Person("aaa", 20);
		Person p2 = new Person("zzz", 12);
		Person p3 = new Person("ccc", 32);
		Person p4 = new Person("eee", 40);
		Person p5 = new Person("nnn", 54);
		
		
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		
		System.out.println(list);
		Collections.sort(list); 
		System.out.println(list);
	}

}
