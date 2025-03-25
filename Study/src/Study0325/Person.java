package Study0325;

public class Person {
	
	char gender;
	String name;
	int age;
	
	//만들 수 있는 모든 생성자를 만들기
	
	Person(){System.out.println("1번 생성자");}
	
	Person(int age, char gender, String name){
		this.age=age;
		this.gender=gender;
		this.name=name;
	}
	
	Person(int age){
		this.age=age;
	}
	
	Person(char gender){
		this.gender=gender;
	}
	
	Person(String name){
		this.name=name;
	}
	
	Person(int age, char gender){
		this.age=age;
		this.gender=gender;
	}
	
	Person(int age, String name){
		this.age=age;
		this.name=name;
	}
	
	Person(char gender, String name){
		this.gender=gender;
		this.name=name;
	}
}
