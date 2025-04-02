package Study0402;

public class Person {
	
	int age;
	String name;
	double weight;
	
	Person(){}
	
	Person(int age, String name, double weight){
		this.age = age;
		this.name = name;
		this.weight =weight;
	}
	void eatFood(Food f) {
		if(f instanceof Ramen){
			Ramen r =(Ramen)f;
			System.out.println("현재 몸무게 : " + (weight + r.cal*0.001));
		}
		else if (f instanceof Tteokguk) { // Tteokguk이면 메시지만 출력
			Tteokguk t = (Tteokguk) f;
			System.out.println(t.food + "을 먹습니다.");
	}
	}
	
	
	
	
}
