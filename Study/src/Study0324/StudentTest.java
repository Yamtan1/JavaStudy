package Study0324;

public class StudentTest {
// 클래스의 구성요소
// 1. 멤버 변수(필드) - 클래스 안에 선언된 변수이므로 멤버 변수라고 부른다.
// 2. 멤버함수(메소드) - 클래스 안에 선언된 함수이므로 멤버함수라 하고, 메소드라고 부른다.
	public static void main(String[] args) {
		// 번호 이름 각 과목의 점수를 멤버변수로 하라고 했다.
		// 학생이란 위의 것들로 구성되어 있다고 봄.
		// 번호에 해당하는 멤버변수는 타입은 무엇으로 하는게 좋을것인가. 이름 과목들도 마찬가지
		Student James = new Student();
		Student Ann = new Student();
		Student Bread = new Student();
		
		James.num = 1;
		James.name = "James";
		James.kor = 80;
		James.eng = 70;
 		James.math = 60;
 		James.info();
 		
 		Ann.num = 2;
 		Ann.name = "Ann";
 		Ann.kor = 65;
 		Ann.eng = 75;
 		Ann.math = 73;
 		Ann.info();
 		
 		Bread.num = 3;
 		Bread.name = "Bread";
 		Bread.kor = 99;
 		Bread.eng = 93;
 		Bread.math = 91;
 		Bread.info();

		
	}

}