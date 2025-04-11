package Study0411;

public class Calculator implements Ical{
	
	@Override	
	public int sum(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
	@Override
	public int sub(int num1, int num2) {
		int sub = num1 - num2;
		return sub;
	}
	@Override
	public int mul(int num1, int num2) {
		int mul = num1 * num2;
		return mul;
	}
	@Override
	public double div(int num1, int num2) {
		double div = (double)num1 / num2;
		return div;
	}
	}
