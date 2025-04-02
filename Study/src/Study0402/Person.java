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
			((Ramen) f).eat(this);
		}
		else if (f instanceof Tteokguk) { // Tteokguk이면 메시지만 출력
		((Tteokguk) f).eat();
	}
	}
	
	
	
	
}
