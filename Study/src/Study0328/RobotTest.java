package Study0328;

import java.util.Scanner;

public class RobotTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Robot x = new Robot("ㅇㅇㅇ", 5);
		
		while(true) {
			int input = sc.nextInt(2);
			if(input == 0) {
				x.complimnet();
				System.out.println(x);
				continue;
			}
			
			else if(input == 1) {
				x.scold();
				System.out.println(x);
				continue;
			}
		}		
	}

}
