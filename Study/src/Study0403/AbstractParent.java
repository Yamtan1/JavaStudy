package Study0403;

public abstract class AbstractParent {
	private int n;
	
	/* public AbstractParent(){
		System.out.println("AbstractParent 생성자 호출"); 
	} */
	public AbstractParent(int n) {
		System.out.println("AbstractParent 생성자 호출");
		this.n = n;
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void f() {
		System.out.println("f()함수 실행...");
	}
		
	public abstract void af();

			
}
