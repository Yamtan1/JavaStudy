package Study0326;

import vo.A; // ctrl + shift + o

public class Atest {

	public static void main(String[] args) {
	
		A a = new A();
		a.setN(20);
		a.setS("Hello");
		System.out.println(a.getN());
		System.out.println(a.getS());
		System.out.println(a.showInfo());
		System.out.println(a);
	}
}