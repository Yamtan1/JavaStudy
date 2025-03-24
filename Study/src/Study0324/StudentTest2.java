package Study0324;

public class StudentTest2 {

	public static void main(String[] args) {
		// 1. 3명 학생인스턴스를 생성하시오 
		// 2. 1번을 활용해서 학생 배열을 만드시오
		// 3. 학생들의 국어점수 합계를 구하시오
		Student James = new Student();
		Student Ann = new Student();
		Student Bread = new Student();
		Student[] list= {James, Ann, Bread};
		int korSum = 0;
		
		James.num = 1;
		James.name = "James";
		James.kor = 80;
		James.eng = 70;
		James.math = 60;
		
		Ann.num = 2;
		Ann.name = "Ann";
		Ann.kor = 65;
		Ann.eng = 77;
		Ann.math = 90;
		
		Bread.num = 3;
		Bread.name = "Bread";
		Bread.kor = 93;
		Bread.eng = 78;
		Bread.math = 75;
		
		
		for(int i = 0 ; i < list.length ; i++) {
			korSum = korSum + list[i].kor;	
		}
		System.out.println(korSum);
		
	}

}
