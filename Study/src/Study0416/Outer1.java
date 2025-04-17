package Study0416;

public class Outer1 {
	
	private int speed = 10;
	
	class MemberInner1{//클래스안에 클래스를 저장하면 내부클래스
					   //외부 클래스가 내부클래스를 매우 필요로 하다는 관계
		public void move() {
			System.out.printf("인간형 유닛이 %d 속도로 이동합니다.\n", speed);
		}
	}
	
	public void getUnit() {
		MemberInner1 inner = new MemberInner1();
		inner.move();
	}
}
