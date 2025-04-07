package Study0407;

public class ObTest {


	public static void main(String[] args) {
		
		ArrPlus a1 = new ArrPlus();
		a1.add(1);
		a1.add(Integer.valueOf(50));
		a1.add(Double.valueOf(1.879789));
		a1.add(Float.valueOf(1.3f));
		a1.add("아악");
		a1.add(true);
		a1.add(false);
		a1.add(8);
		
		a1.print();
		
		Object[] objs = new Object[3];
		objs[0] = "Hello";
		objs[1] = new A(1, "James");
		objs[2] = new B(2.3f,'B');
		
		//배열이 꽉찼으니 새로운 데이터를 넣기 위해 더 큰 배열을 만들어야겠다.
		Object[] temp = new Object[objs.length+3];
		temp[0] = objs[0];
		temp[1] = objs[1];
		temp[2] = objs[2];
		
		objs = temp;
		
		objs[3] = "Good";
		objs[4]	= new A(32,"Ann");	
		objs[5] = new B(1.4f,'C');
		
	
		
		
	}

}

class A{
	private int n;
	private String s;
	
	A(int n, String s){
		this.n=n;
		this.s=s;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
class B{
	float f;
	char c;
	
	B(float f, char c){
		this.f=f;
		this.c=c;
	}

	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
	
}

