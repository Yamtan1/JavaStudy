package Study0317;

public class SecondQ0317 {

	public static void main(String[] args) {
		
		linePrint(15);
		linePrint(20);
		linePrint(25);
		
		lintPrint2(25, '?');
		lintPrint2(30, '?');
	}
	/*public static void linePrint(int n) {
		for(int i = 0 ; i < n ; i++) {
			System.out.print("----------");
			System.out.println();
		}
	}*/
	public static void linePrint(int n) {
		for(int i = 0 ; i < n ; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	public static void lintPrint2(int x, char z) {
		for(int i = 0 ; i < x ; i++) {
			System.out.print(z);
		}
		System.out.println();
	}
}
