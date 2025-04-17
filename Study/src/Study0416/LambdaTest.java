package Study0416;

public class LambdaTest {

	public static void main(String[] args) {
		/*	
		Unit unit = new Human();
		unit.move();
		*/
		
		/*
		Unit unit = new Unit(){ //익명클래스

			@Override
			public void move() {
				System.out.println("인간이 움직인다구요");
			}		
		};
		unit.move();
		*/
		
		Unit2 unit = (s) -> s.length(); //인터페이스에 추상메서드가 하나만 있기 때문에 가능함(람다식)
		//매개변수가 하나이면 소괄호 생략가능
		//두 개 이상일 경우 소괄호 사용
		//명렁어가 하나일 경우 중괄호 생략가능
		//리턴문일 경우 한줄이라도 중괄호 사용
		int result = unit.move("move move...");
		System.out.println(result);
	} //End of main

}
