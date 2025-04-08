package Study0408;

import java.util.ArrayList;
import java.util.Scanner;

public class TestStudent2 {
	//강사님꺼
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student s1 = new Student("James", 93);
		Student s2 = new Student("Ann", 46);
		Student s3 = new Student("Candy", 100);
		Student s4 = new Student("Bruce", 64);
		Student s5 = new Student("Ben", 56);
		
		ArrayList<Student> sList = new ArrayList<>();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		sList.add(s5);
		
		boolean flag = true;  
		while(flag) {
			System.out.print("번호를 입력하세요 >> ");
			int sno = sc.nextInt();
			sc.nextLine();
			System.out.print("이름을 입력하세요 >> ");
			String name = sc.nextLine();
			
			flag = StudentChecker.checkStudentInfo(sList, sno, name);
			if(flag) {
				System.out.println("번호와 이름을 확인하세요.");
			}
		}
	}
	
	public static boolean checkStudentInfo(ArrayList<Student> sList, int sno, String name) {
		boolean flag = true;
		for(Student s : sList) {
			if(s.getSno() == sno && s.getSname().equals(name)) {
				System.out.println(s.getSname() + "의 점수는 " + s.getScore() + "점입니다."); 
				flag = false;
				break;
			}
		}
		return flag;
	}
	
}
