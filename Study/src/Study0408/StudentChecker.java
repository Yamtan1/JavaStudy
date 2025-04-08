package Study0408;

import java.util.ArrayList;
	//강사님꺼
public class StudentChecker {
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
