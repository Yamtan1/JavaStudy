package Study0411;

public interface Ical {
	
	public int sum(int num1, int num2);
	public int sub(int num1, int num2);
	public int mul(int num1, int num2);
	public double div(int num1, int num2);
	public default int square(int no) {
		int result = no * no;
		return result;
	}
}
