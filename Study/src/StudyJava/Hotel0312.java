package StudyJava;

import java.util.Scanner;

public class Hotel0312 {

	public static void main(String[] args) {
		// 10개의 방이 있는 호텔이다
		// 프로그램이 시작되면 하나도 예약이 안되어있는 상태로 시작한다
		// 화면에는 예약이 안되어 있는 상태의 현황을 보여준다
		// 예약이 안되어 있으면 0 되어있으면 1로 표현
		// 몇번 방을 예약하시겠습니까? 라고 나옴
		// 1 을 누르고 엔터를 누르면 0 에서 1로 바뀐다.
		// 몇번방을 예약하시겠습니까 -> 2치면 2가 1이 올라간다
		// 이미 예약이 되어있는 방을 누르면 이미 예약되어있는 방입니다 라고 안내문 출력 및 다시 몇번방을 예약하시겠습니까.
		// 퇴실 따윈 없다.
		// 10개 방이 다 찼을 경우 만실입니다 라고 안내후 예약을 받지 않고 프로그램을 종료
		
		Scanner sc = new Scanner(System.in);
		int[] RoomNum = new int[10];
		int[] Check = new int[10];
		
		while(true) {
		System.out.println("예약 현황");
		for(int i = 0 ; i < RoomNum.length ; i++) {
			RoomNum[i]=i+1;
			System.out.print(RoomNum[i] + "번방" + "     ");
		}
		System.out.println();
		
		for(int i = 0 ; i < Check.length ; i++) {
			System.out.print(Check[i] + "        ");
			}
		System.out.println();
		System.out.print("몇 번 방을 예약하시겠습니까? >>> ");
		int ans = sc.nextInt(); 
		if(Check[ans-1] == 1) {
			System.out.println("이미 예약된 방입니다.");
		}
		else {
			switch(ans) {
			case 1 : Check[ans-1]++; break;
			case 2 : Check[ans-1]++; break;
			case 3 : Check[ans-1]++; break;
			case 4 : Check[ans-1]++; break;
			case 5 : Check[ans-1]++; break;
			case 6 : Check[ans-1]++; break;
			case 7 : Check[ans-1]++; break;
			case 8 : Check[ans-1]++; break;
			case 9 : Check[ans-1]++; break;
			case 10 : Check[ans-1]++; break;
			}
			System.out.println("예약이 완료 되었습니다." + " (선택한 방 : " + ans + "번방)" );
		}
		}
	}
}
