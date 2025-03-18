package Study0318;

import java.util.Random;
import java.util.Scanner;

public class Game0318 {
	static int win = 0; //전역 변수로 어느 함수에서든 사용 가능
	static int lose = 0;
	static int draw = 0;
	static int total = 0;
	public static void main(String[] args) {
		// 가위바위보 게임 랜덤수를 함수로
		// 사용자가 입력하는 것도 함수로
		// 승패 판별 함수도 만들기
		
		while(true) {
		System.out.println("가위바위보를 진행합니다.");
		int x = rd();
		int z = input();
		if(z == 1) {
			System.out.println("플레이어 : 가위");
		}
		else if(z == 2) {
			System.out.println("플레이어 : 바위");
		}
		else {
			System.out.println("플레이어 : 보");
		}
		if(x == 1) {
			System.out.println("com : 가위");
		}
		else if(x == 2) {
			System.out.println("com : 바위");
		}
		else {
			System.out.println("com : 보");
		}
		win(x, z);
		
		}
		
	}
	static int rd() {
		Random rd = new Random();
		int rdnum = rd.nextInt(3) + 1;
		System.out.println("com : ???");
		return rdnum;
	}
	static int input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1: 가위, 2: 바위, 3: 보 입니다.");
		System.out.print("숫자를 입력하세요 >> ");
		int inputNum = sc.nextInt(4);
		return inputNum;
	}
		
	static void win (int a, int b) {
		int i = a;
		int i2 = b;
		if(i == i2) {
			total++;
			draw++;
			System.out.println("비겼습니다.");
		}
		else if((i == 1 && i2 == 2) || (i == 2 && i2 == 3) || (i == 3 && i2 == 1)) {
			total++;
			win++;
			System.out.println("이겼습니다.");
		}
		else {
			total++;
			lose++;
			System.out.println("졌습니다.");
		}
		System.out.println("승 : " + win + " 패 : " + lose + " 무 : " + draw);
		System.out.println("총 진행 횟수 : " + total);
		System.out.println("\t");
	}

}
