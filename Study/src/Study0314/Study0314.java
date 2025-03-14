package Study0314;

public class Study0314 {

	public static void main(String[] args) {
		// 2차원 배열 int[][] arr = new int[3][5]
		int[][] arr = new int[3][5];
		
		for(int i = 0 ; i< arr.length; i++) {
			for(int x = 0 ; x < arr[i].length ; x++) {
				arr[i][x] = 1;
				System.out.print(arr[i][x] + " ");
			}
			System.out.println("\t");
		}
	}

}
