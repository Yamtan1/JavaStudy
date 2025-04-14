package Study0414;

import java.util.HashSet;
import java.util.Set;

public class MemberTest {

	public static void main(String[] args) {

		Member m1 = new Member();
		m1.setMno(1);
		m1.setName("aaa");
		m1.setPhone("010-1111-1111");

		//System.out.println(m1);

		Member m2 = new Member();
		m2.setMno(1);
		m2.setName("aaa");
		m2.setPhone("010-1111-1111");


		System.out.println(m1.equals(m2)); //인스턴스를 비교해야하는 클래스시 equals를 오버라이딩 해라

		System.out.println(m1 == m2);

		Member m3 = m1;

		System.out.println(m1 == m3);

		Set<Member> set = new HashSet<>(); //인스턴스 비교시 equals뿐만아니라 HashCode라는 메서드도 오버라이딩 해줘야함 
		set.add(m1);
		set.add(m2);

		System.out.println(set.size());


	}

}

