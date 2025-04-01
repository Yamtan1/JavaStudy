package Study0401;

public class TravelTest {

	public static void main(String[] args) {
		// 콘솔에 버스를 타고 부산여행을 간 결과로 '부산행 버스에 몸을 싣고...'가 출력되게 하시오
		// 콘솔에 기차를 타고 부산여행을 간 결과로 '부산행 기차에 몸을 싣고...'가 출력되게 하시오
		// abstract 추상 클래스는 메소드 생성이 안되지만 상속은 가능하다. 상속받은 클래스는 반드시 추상클래스의 메서드를 완성 시켜야 한다. 인스턴스 생성은 할 수 없지만 상속은 가능하다
		// 추상 메서드는 상속받는 메서드 간의 약속이다 미완성된 메서드가 있기 때문에 반드시 그메서드를 완성해야한다
		Bus b1 = new Bus();
		Train t1 = new Train();
		
		BusanTravel p1 = new BusanTravel();
		//p1.goBusan(b1);
		//p1.goBusan(t1);
		
		Transportation d = new Transportation();
		d.goBusan(b1);
		d.goBusan(t1);
		
		
	}

}
