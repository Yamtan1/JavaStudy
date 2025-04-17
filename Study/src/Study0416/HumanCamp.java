package Study0416;

import Study0416.Outer1.MemberInner1;

public class HumanCamp {

	public int speed = 10;
	
	public void getMarine() { //함수안에 클래스가 있음 메인에서Outer1.MemberInner1 inner = out.new MemberInner1();이런식으로 생성이 불가능함 
		
		class Marine{
			
			public void move() {
				System.out.println("인간형 유닛이" + speed + "속도로 이동합니다");
			}
		}
		
		Marine inner = new Marine();
		inner.move();
	}
}
