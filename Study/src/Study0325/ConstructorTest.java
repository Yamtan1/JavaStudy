package Study0325;

public class ConstructorTest {

	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println(s1.no + s1.name + s1.gender);
		Student s2 = new Student(1,"홍길동",'M');
		System.out.println(s2.no + s2.name + s2.gender);
		Student s3 = new Student(3,"길동");
		System.out.println(s3.no + s3.name + s3.gender);
		
		s2.setNo(30);  //Setter 함수
		s2.setName("임꺽정"); //Setter 함수 
		s2.setgender('F'); //Setter 함수
		System.out.println(s2.no + s2.name + s2.gender);
		
		//Getter 함수
		int y = s2.getNo();
		System.out.println(y);
		String z = s2.getName();
		System.out.println(z);
		char i = s2.getGender();
		System.out.println(i);
	}

}
 