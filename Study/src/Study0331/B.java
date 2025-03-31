package Study0331;

public class B extends A{
	int k;
	
	void fb() {
		System.out.println("fb함수 실행");
	}
	
	@Override //이미 만들어져 있는 함수의 기능을 수정한 것
	void fa() {
		System.out.println("클래스 B의 fa함수 실행중");
	}
	
	B(){
		//super(10); // super는 부모클래스를 의미, 부모 클래스의 생성자를 호출한다는 뜻.
		System.out.println("B생성자 실행");		
	}
	B(int n){
		super(n); // 항상 제읾 먼저 와 있어야함.
	}
	B(int k, int n){
		super(n); //this.n = n; 도 사용 가능
		this.k=k;
	}
}
