package StudyJava;

import java.util.Scanner;

public class Study0312 {

	public static void main(String[] args) {
		
		//1234 입력한 수들의 합 :10 . 527 ->14
	
		Scanner sc = new Scanner(System.in);
		System.out.println(" 숫자를 입력하세요 ");
		
		int Num = sc.nextInt();
		int[] A = new int[4];
		
		int r1 = Num / 10;
		System.out.println("r1 : " + r1);
		A[3] = Num % 10;
		int r2 = Num / 100;
		System.out.println("r2 : " + r2);
		A[2] = r1 % 10;
		int r3 = Num / 1000;
		System.out.println("r3 : " + r3);
		A[1] = r2 % 10;
		int r4 = Num / 10000;
		System.out.println("r4 : " + r4);
		A[0] = r3 % 10;
		int sum = 0;
		for(int i = A.length - 1 ; i>=0 ; i--) {
			System.out.println("A[" + i + "] = " + A[i]);
			sum = sum + A[i];
			System.out.println(sum);
		}
	}

}
