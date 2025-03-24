package Study0324;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator a = new Calculator();
		int n1 = 15;
		int n2 = 4;	
		int sum = a.sum(n1, n2);
		System.out.println(sum);
		int sub = a.sub(n1, n2);
		System.out.println(sub);
		int mul = a.mul(n1, n2);
		System.out.println(mul);
		double div = a.div(n1, n2);
		System.out.println(div);
	}

}
