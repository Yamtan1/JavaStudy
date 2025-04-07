package Study0407;

public class XYTest {

	public static void main(String[] args) {
		
		X a = new X();
		a.x=10;
		System.out.println(a.x);
		
		Y b = new Y();
		b.y = "hello";
		System.out.println(b.y);
		
		//상속!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		Object a1 = new Y();
		
		
		Y b1 =(Y)a1;
		b1.y = "bye";
		System.out.println(b1.y);
	}

}
