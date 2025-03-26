package vo; //value object 라는 뜻  dto는 데이터 전송용

public class A {
	private int n;
	private String s;
	public void setN(int n) { //public 을 붙이면 다른패키지에 있어도 사용 가능
		this.n = n;
	}
	
	public int getN() {
		return n;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	public String showInfo() {
		return "n = " + n + ", s = " + s;
	}
	@Override //@가 붙어있는 애들을 어노테이션이라고 함. 오버라이드란 이미 정의 되어있는 메서드를 사용자가 재정의 하고 있다라는 표식, 함수이름을 틀리지 않도록 오류를 나타나게하는 역할도 한다.
	public String toString() { //모든 클래스는 toSting이라는 메서드를 가지고 있는 상태이다. toString은 사용자가 정의를 내리면 사용자가 정의내린 기능을 수행한다.
								//인스턴스의 멤버변수의 값들을 제공하는 기능을 하는 것으로 약속되어있다.
		return "A]n = " + n + ", s = " + s;
	}
	
	
}
// 캡슐화라는 것에는 정보은닉(information hiding)이 담겨있음
// 은닉된 정보에 접근하는 public 메서드가 존재해야한다.
// 오버라이드는 함수의 시그니처는 같아야하고 내용은 바꿀 수있다. 오버로딩은 함수의 이름은 같아도 함수의 시그니처는 달라야한다.