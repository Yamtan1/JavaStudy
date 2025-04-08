package Study0408;

import java.util.ArrayList;

public class SearchStudent {
	
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
