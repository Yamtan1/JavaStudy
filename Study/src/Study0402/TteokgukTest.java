package Study0402;

public class TteokgukTest {

	public static void main(String[] args) {

		Person p1 = new Person(20, "홍길동",90);
		Tteokguk t1 = new Tteokguk();
		Ramen r1 = new Ramen("신라면",456);
		Person p2 = new Person(20, "홍길순",80);
		/* p1.eat(t1);
		System.out.println(p1.age); */
		
		//라면 클래스 라면을 먹으면 몸무게가 늘어남
		//라면을 먹으면 음식 칼로이의 1000분의 1이 늘어남
		//함수로 만들기
		
		p1.eatFood(t1);
		p2.eatFood(r1);
		p1.eatFood(r1);
	}

}
