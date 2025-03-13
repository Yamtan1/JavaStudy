package Study0313;

public class Study0313 {

	public static void main(String[] args) {
		// continue 활용
		
		for(int i = 0 ; i < 10 ; i ++) {
			if(i == 5) {
				continue; // continue 이후에 있는 코드 명령은 건너 뜀
			}
			System.out.println(i);
		}
	}

}