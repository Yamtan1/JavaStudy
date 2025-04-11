package Study0411;

public class CalculatorTest {

	public static void main(String[] args) {
		
		Calculator2 c1 = new Calculator2();
		int n = 10;
		int n1 = -13;
		System.out.println(c1.sum(n, n1));
		System.out.println(c1.sub(n, n1));
		System.out.println(c1.mul(n, n1));
		System.out.println(c1.div(n, n1));
		int x = c1.abs(c1.mul(n, n1));
		double y = c1.doubleabs(c1.div(n, n1));
		System.out.println(y);
		
		Calculator c2 = new Calculator();
		
		System.out.println(c2.square(n1));
		
	}

}
