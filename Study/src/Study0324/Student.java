package Study0324;

public class Student {
	// 클래스를 만드는데 학생클래스를 만든다
	// 번호, 이름, 국어점수, 영어점수, 수학점수
	// 국어는 kor 영어는 eng 수학은 math 변수명
	// 번호는 num 이름은 name
	// 함수는 학생의 모든 정보를 보여주는 함수(번호 이름 국영수 점수)
	// 학생 3명의인스턴트 만들어서 3명의 정보를 콘솔에다 출력하기
	// 참조변수 명 James, Ann, Bread
	int num;
	String name;
	int kor;
	int eng;
	int math;
	
	void info() {
		System.out.println("번호 : " + num + "번" + " 이름 : " + name + " 국어 : " + kor + " 영어 : " + eng + " 수학 : " + math );
	}
}

