package Study0327;

public class StaticMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AAA a = new AAA();
		AAA.y=70;
		a.nonStaticf();
		
		
		AAA.staticF();
		AAA.x=10;
		AAA.staticF();
	}

}
