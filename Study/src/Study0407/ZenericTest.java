package Study0407;

import java.util.ArrayList;
import java.util.List;

public class ZenericTest {

	public static void main(String[] args) {
		
		Box<String> box = new Box<>(); //Box 클래스의 T가 String으로 정해짐
		box.t="hello";
		System.out.println(box.t);
		
		Box<X> xbox = new Box<>();
		xbox.t = new X();
		xbox.t.x = 10;
		System.out.println(xbox.t.x);
		ArrayList<Integer> li = new ArrayList<>();
		ArrayList<Object> li2 = new ArrayList<>();
		li2.add("아악");
		li2.add(15);
		li2.add('H');
		li2.add(1.894894);
		li2.add(1.8f);
		li2.add(true);
		li2.add(false);
		
		System.out.println(li2);
		
		li.add(12);
		li.add(12);
		li.add(12);
		li.add(12);
		li.add(12);
		li.add(12);
		li.add(12);
		li.add(12);
		
		System.out.println(li.get(0));

	}

}
