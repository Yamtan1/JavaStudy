package StudyJava;

import java.util.Random;

public class Study20312 {
	
	public static void main(String[] args) {
	
		//주사위를 100번 굴릴 거임.
		//100번동안 표에 나온 눈들의 횟수를 적을거임
		//1: 10번 2: 25번 3:5번 4:30번 5: 15번 6:15번

		Random rd = new Random(); 
		int[] table = new int[6]; // 1~6까지의 주사위 눈을 담을 공간 생성
		
		for(int i = 0; i < 100 ; i++) { //100번 반복하기위한 반복문
			int Dice = rd.nextInt(6) + 1; //1~6까지 랜덤숫자 생성
			table[Dice-1]++;			// 주사위 눈을 기록하기 위한 table 인덱스 번호는 주사위 눈의 -1, 값을 더하는 것이 아니기에 ++;로 해당 인덱스의 값을 1만 증가시키기	
		}
		
		for(int i = 0; i < table.length; i++) {
			System.out.println((i+1) + "이 나온 횟수 : " + table[i]);
		}
		
		// switch 문
		int x = 4;
		switch(x) {
		case 1 : System.out.println("1입니다"); break;
		case 2 : System.out.println("2입니다"); break;
		case 3 : System.out.println("3입니다"); break;
		default: System.out.println("1도 2도 3도 아닙니다"); break;
		}
		
		char c = 'C';
		switch(c) {
		case 'A' : System.out.println("A입니다"); break;
		case 'B' : System.out.println("B입니다"); break;
		case 'C' : System.out.println("C입니다"); break;
		default: System.out.println("A도 B도 C도 아닙니다"); break;
		}
		String s = "A";
		switch(s) {
		case "A" : System.out.println("A입니다"); break;
		case "B" : System.out.println("B입니다"); break;
		case "C" : System.out.println("C입니다"); break;
		default: System.out.println("A도 B도 C도 아닙니다"); break;
		}
		char q = 'C'; //A는 65 B는 66 C는 67 메모리상 이렇게 저장되어있음. 아스키코드표
		switch(q) {
		case 65 : System.out.println("A입니다"); break;
		case 66 : System.out.println("B입니다"); break;
		case 67 : System.out.println("C입니다"); break;
		default: System.out.println("A도 B도 C도 아닙니다"); break;
		}
		char i = 'A'; // 아스키 코드로 출력해보기
		System.out.println((int)i); // i를 int형(정수형)으로 출력
	}
}
