package Study0402;

public class Ramen extends Food {
	String name;
	double cal;
	
	Ramen(String name,double cal){
		this.cal=cal;
		this.name = name;

	}
	void eat(){  //방법2

	}

	/* void eat(Person p) {  //방법 1

		p.weight = p.weight + cal*0.001;
		System.out.println(p.weight);
	} */
}
