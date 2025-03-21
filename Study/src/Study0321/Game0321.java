package Study0321;

import java.util.Scanner;

public class Game0321 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = {'J','a','v','a',' ','i','s',' ','e','a','s','y'};
		char[] temp = new char[str.length];
			for(int i = 0 ; i < str.length ; i ++) {
				if (str[i]==32){
					temp[i]=str[i];
				}
				else {
					temp[i] = '*';
				}
				System.out.print(temp[i]);
			}
			System.out.println();
	while(true) {
		System.out.print("Call character ! >>");
		int input = sc.nextInt();
		for(int y = 0; y < str.length ; y++) {
			if(input == str[y]) {
				temp[y]=str[y];
			}
			else if(str[y] == 32) {
				temp[y]=str[y];
			}
			System.out.print(temp[y]);
		} 
		System.out.println();
		boolean flag = true;
		for(int z = 0; z < str.length ; z++) {
			if(temp[z] =='*') {
				flag = false;
			}
		}
		if(flag) {
			System.err.println("시스템을 종료합니다.");
			break;
		}
	}
	}
}
