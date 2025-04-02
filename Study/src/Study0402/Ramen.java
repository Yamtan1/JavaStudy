package Study0402;

public class Ramen extends Food {
	String name;

	
	Ramen(String name,int cal){
		super(cal);
		this.name = name;

	}
	void eat(Person p) {
		p.weight =p.weight + (cal*0.001);
		System.out.println(p.weight);
	}
}
