package Study0319;

public class Sort {

	public static void main(String[] args) {
		int[] arr = {5,6,2,1,4,3};
		int temp = -1;
		
		for(int i = 0 ; i < arr.length -1; i++) {
			for(int j = i + 1 ; j < arr.length ; j++) {
				if(arr[i] >= arr[j]) {
					temp= arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
			
		}
		for(int x = 0 ; x < arr.length ; x ++) {
			System.out.println(arr[x]);
		}
	}
}