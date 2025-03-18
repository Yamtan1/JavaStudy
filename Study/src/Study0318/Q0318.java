package Study0318;

public class Q0318 {

	public static void main(String[] args) {
		// 
		/*
		 * AAAAAAAAAAAAAAAAAAAA
		 * 
		 * ---End---
		 */
		// 5번째마다 A를 B로 바꿔라
		int n = 20;
		char x = 'A';
		f(n, x);
		
		
		System.out.println("\n---End---");
	}
	public static void f(int x, char z) {
		for(int i = 0 ; i < x ; i++) {
			
			if(i % 10 == 4) {
				System.out.print('B');
			}
			else if(i % 10 == 9) {
				System.out.print('B');
			}
			else {
				System.out.print(z);
			}
		}
		System.out.println();
	}
}
