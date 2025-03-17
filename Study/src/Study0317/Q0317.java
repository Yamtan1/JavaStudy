package Study0317;

import java.util.Scanner;

public class Q0317 {

	public static void main(String[] args) {
		// 메인함수가 있는데 메인함수가 f1을 호출할때도있음 f2함수를 호출할때도 있음
		//f1함수는 f1함수실행 출력, f2는 f2함수실행 출력
		//스캐너 사용해서 숫자를 입력하세요 >> ___ 숫자 입력후 엔터 음수를 입력하면 종료 양수 짝수 입력시 f1함수 실행 홀수 입력시 f2함수 실행
		
		while(true) {
			System.out.print("숫자를 입력하세요 >> ");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();	
			
			if(num % 2 == 0) {
				f1();
			}
			else if(num % 2 == 1) {
				f2();
			}
			else {
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
		
	}
	public static void f1() {
		System.out.println("f1함수를 실행 중 입니다.");
		
	}
	public static void f2() {
		System.out.println("f2함수를 실행 중 입니다.");
	}
}