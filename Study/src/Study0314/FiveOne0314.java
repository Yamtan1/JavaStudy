package Study0314;

import java.util.Random;
import java.util.Scanner;

public class FiveOne0314 {

	public static void main(String[] args) {
		// 5열 5행짜리 배열의 이름은 board 정수배열임 
		//프로그램이 시작되면  자동으로 1이라는 숫자가 모든곳이아니라 5곳에만 저장되게 할거임
		//프로그램시작되면 5행 5열배열이 1 5개가 숨어있다 1이 있는 지역을 찾아라
		//몇행 몇열에 있는지 입력하는 안내문이 나옴
		// 있으면 있다 없으면 없다
		//5개가 다찾으면 게임이 끝남.
		// 어디어디에 있었다 안내해주고 몇번째에 맞췄는지 알려주고
		// 5 5 배열의 모습도 출력하기
		// 몇분만에 끝났는지 카운팅을 할 수 도 있을걸 << 이건 재량껏
		
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Random rc = new Random();
		
		int[][] board = new int[5][5];
		int count = 0;
		int count1 = 0;
		boolean flag = true;
		int totalc = 0;
		
		while(count < 5) {
			
			flag = true;
			int i = rc.nextInt(5);
			int x = rc.nextInt(5);
				if(board[i][x] == 1) {
					System.out.println("중복갑 발견" + "( " + i + ", " + x + ")" );
						flag = false;
						continue;
				}
			if(flag) {
				board[i][x] = 1;
			}
			count++;
		}
		System.out.println("5행 5열로 되어있는 25칸 블럭안에 숫자 1이 5개가 들어가 있는 곳을 찾으시오");
		while(count1<5) {
				
		System.out.println("(1 ~ 5까지 입력가능)");
		System.out.print("행 입력 : ");
		int in = sc.nextInt(5) +1;
		System.out.print("열 입력 : ");
		int in1 = sc.nextInt(5) + 1;
		if(board[in-1][in1-1] == 0) {
			System.out.println("틀렸습니다.");
		}
		if(board[in-1][in1-1] == 1) {
			System.out.println("정답입니다.");
			count1++;
		}
		totalc++;
		}
		if(count1 == 5) {
			for(int i = 0 ; i<board.length ; i ++) {
				for(int x = 0 ; x <board[i].length ; x++) {
					System.out.print(board[i][x] + " ");
				}
				System.out.println("\t");
			}
			System.out.println("5개를 모두 찾았습니다 축하합니다.");
			System.out.println("총 진행한 횟수 : " + totalc);
		}
	}
}