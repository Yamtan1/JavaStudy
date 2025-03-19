package Study0319;

import java.util.Scanner;

public class Vending {

	public static void main(String[] args) {
		// 자판기 만들기....
		// 자판기를 사용할 사람이 있어야함. 공급자도 있어야함. 
		// 사용자는 자판기를 대상으로 (돈을 넣는다, 상품을 고른다, 잔돈을 가져간다, 상품도 가져간다)
		// 공급자는 자판기를 대상으로 (상품을 채워넣는다, 돈을 채워넣는다, 돈을 회수한다, 동작여부를 확인한다)
		// 돈을 넣었을때 돈이 부족하면 돈을 더 넣으라는 메세지 및 넣었을때 구매가능한 상품을 보여줌.
		// 돈을 넣고 반환할 경우 돈돌려주기
		int x = money();
		int z = buy(x);
		int[] y = choice(z);
		payback(y[0], y[1]);

	}
	public static int money() {
		System.out.println("금액을 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		return input;
	}
	public static int buy(int n) {
		Scanner sc = new Scanner(System.in);
		int m = n;
		while(true) {
		System.out.println("상품을 골라주세요.");
		System.out.print("1. 아메리카노 1000원");
		System.out.print("\t"+"2. 카페라떼 2000원"+"\t");
		System.out.print("\t"+"3. 바닐라라떼3000원"+"\t");
		System.out.println("\t"+"4. 아인슈페너 4000원"+"\t");
		if(1000 <= m) {
			System.out.print("---구매 가능---"); 
		}
		else {
			System.out.print("---구매 불가---"); 
		}
		if(2000 <= m) {
			System.out.print("\t\t---구매 가능---");
		}
		else {
			System.out.print("\t\t---구매 불가---"); 
		}
		if(3000 <= m) {
			System.out.print("\t\t---구매 가능---");
		}
		else {
			System.out.print("\t\t---구매 불가---");
		}
		if(4000 <= m) {
			System.out.println("\t\t---구매 가능---");
		}
		else {
			System.out.println("\t\t---구매 불가---");
		}
		if(m < 1000) {
			System.out.println("금액이 부족합니다. 금액을 더 입력해주세요.");
			int input2 = sc.nextInt();
			m = m + input2;
			//System.out.println(m);
			continue;
			}
			break;
		}
		return m;
	}
	public static int[] choice(int i) {
		Scanner sc = new Scanner(System.in);
		int[] choose = new int[2];
		choose[1] = i;
		while(true) {
			//System.out.println(choose[1]);
			choose[0] = sc.nextInt();
		if((choose[0]==1 && choose[1]<1000)) {
			System.out.println("금액이 부족하여 구매할 수 없습니다. 금액을 더 입력해주세요");
			int input3 = sc.nextInt();
			choose[1] = choose[1] + input3;
			System.out.println(input3+"원을 더 입력하셨습니다 재선택 해주십시오. 현재금액 : " + choose[1] + "원");
			continue;
		}
		if(choose[0]==2 && choose[1]<2000) {
			System.out.println("금액이 부족하여 구매할 수 없습니다. 금액을 더 입력해주세요");
			int input3 = sc.nextInt();
			choose[1] = choose[1] + input3;
			System.out.println(input3+"원을 더 입력하셨습니다 재선택 해주십시오. 현재금액 : " + choose[1] + "원");
			continue;
		}
		if(choose[0]==3 && choose[1]<3000) {
			System.out.println("금액이 부족하여 구매할 수 없습니다. 금액을 더 입력해주세요");
			int input3 = sc.nextInt();
			choose[1] = choose[1] + input3;
			System.out.println(input3+"원을 더 입력하셨습니다 재선택 해주십시오. 현재금액 : " + choose[1] + "원");
			continue;
		}
		if(choose[0]==4 && choose[1]<4000) {
			System.out.println("금액이 부족하여 구매할 수 없습니다. 금액을 더 입력해주세요");
			int input3 = sc.nextInt();
			choose[1] = choose[1] + input3;
			System.out.println(input3+"원을 더 입력하셨습니다 재선택 해주십시오. 현재금액 : " + choose[1] + "원");
			continue;
		}
		switch(choose[0]) {
		case 1 : System.out.println("아메리카노를 선택하셨습니다."); break;
		case 2 : System.out.println("카페라떼를 선택하셨습니다."); break;
		case 3 : System.out.println("바닐라라떼를 선택하셨습니다."); break;
		case 4 : System.out.println("아인슈페너를 선택하셨습니다."); break;
		}
		break;
		}
		return choose;
	}
	public static void payback(int n, int m) {
		switch (n){
			case 1 :
				System.out.println("거스름돈은" + (m-1000) + "원입니다."); break;
			case 2 :
				System.out.println("거스름돈은" + (m-2000) + "원입니다."); break;
			case 3 :
				System.out.println("거스름돈은" + (m-3000) + "원입니다."); break;
			case 4 :
				System.out.println("거스름돈은" + (m-4000) + "원입니다."); break;

		}
	}
}