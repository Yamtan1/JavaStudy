package vo;

public class Human {

	private int age;
	private String name;
	
	
	public Human() {} //오버로딩
	
	public Human(int age, String name) { //오버로딩
		this.age = age;
		int result = checkAge(age);
		this.name = name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(int age) {
		int result = checkAge(age);   // 나이를 검증하는 함수의 기능을 활용
		this.age = result;
		/* this.age=age;
		if(200 < age) {
			System.out.println("값의 허용범위를 벗어났어요.");
			this.age=0;
		}
		else if(age < 1) {
			System.out.println("값의 허용범위를 벗어났어요.");
			this.age=0;
		} */
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	private int checkAge(int age) {
		if(age >= 1 && age <= 200) {
			return age;
		}
		else {
			System.out.println("값의 허용 범위를 벗어났어요");
			return 0;
		}
	}
	
	/*public boolean ageveri() { // boolean으로 내가적은거
		boolean x = true;
		if(1 <= age && age <=200) {
			x = true;
		}
		else if(age < 1 || 200 < age) {
			 x = false;
		}
		return x;
	} */
	
	
	
	@Override
	public String toString() {
		if(1 <= age && age <=200) {
			return "이름 : " + name + ", 나이 : " + age;
		}
		else{
			return "이름 : " + name + ", 나이 : " + "미정";	
		}
		
	}
}
