package Study0408;

import java.util.ArrayList;
import java.util.Scanner;

public class TestStudent {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Student s1 = new Student("James", 93);
		Student s2 = new Student("Ann", 46);
		Student s3 = new Student("Candy", 100);
		Student s4 = new Student("Bread", 64);
		Student s5 = new Student("Ben", 56);
		
		ArrayList<Student> sList = new ArrayList<>();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		sList.add(s5);
		
		boolean flag = true;
		while(flag) {
		System.out.println("번호와 이름을 입력하세요 >>>");
		
		int y = sc.nextInt();
		sc.nextLine();
		String x= sc.nextLine();
		
		flag = SearchStudent.search(sList, y, x);
		if(flag) {
			System.out.println("정확한 정보를 입력해주세요"); 
		}
		}
		/* System.out.println("번호와 이름을 입력하세요 >>>");
		
		int y = sc.nextInt();
		sc.nextLine();
		String x= sc.nextLine();
		
		
		for(int i = 0; i < sList.size(); i++) {
			if(x.equals(sList.get(i).getSname()) && y == sList.get(i).getSno()) { //문자열의 값을 비교할땐 equals 사용
				System.out.println(sList.get(i).getSname() + "의 점수는" + sList.get(i).getScore() + "점 입니다.");
				break;
			}
			else{
				System.out.println("정확한 번호와 이름을 입력해주세요");
				break;
			}
		} */
		
		/* int count = 0;
		for(int i = 0; i < sList.size(); i++) {
			Student result = sList.get(i);
			if(sList.get(i).getScore() < 60) {
				count++;
			}
		}
		System.out.println("낙제 점수를 받은 학생은 총 : " + count + "명입니다.");
		
		
		for(Student stu : sList) { //sList의 데이터를 하니씩 꺼내서 stu에 넣어줌 //향상된 for문
			System.out.println(stu);
		} */
		
		//System.out.println(s1.getSno());
		//System.out.println(s2.getSno());
		
		/* Student[] students = new Student[5];
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		students[3] = s4;
		students[4] = s5;
		int count = 0;
		for(int i = 0 ; i < students.length; i++) {
			if(students[i].getScore() < 60) {
				count++;
			}
		}
		System.out.println("낙제 학생 수는 : " + count); */
	}
	
	public static boolean search(ArrayList<Student> sList, int y, String x) {
		boolean flag = true;
		for(int i = 0; i < sList.size(); i++) {
			if(x.equals(sList.get(i).getSname()) && y == sList.get(i).getSno()) { //문자열의 값을 비교할땐 equals 사용
				System.out.println(sList.get(i).getSname() + "의 점수는" + sList.get(i).getScore() + "점 입니다.");
				flag = false;
				break;	
			}
		}
		return flag;
	}

}
