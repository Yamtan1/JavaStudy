package Study0321;

public class Q0321 {

	public static void main(String[] args) {
		// A라는 배열이  'A''B''C''D''E' 이런식으로써있다.
		// 이배열을 출력하는데 ABCDE
		// 다음에는 a b c d e로 출력되게하라

		char [] x = {'A','B','C','D','E'};
	//	System.out.println(x[0]+1); //문자인데 1을 더하니 숫자로 변함. char=2byte, int=4byte 연산이 될때 더 큰 자료의 값으로 츌력됨.
	//	System.out.println((char)(x[0]+1)); // 형변환 진행
		for(int i = 0 ; i < x.length ; i ++) {
			System.out.print(x[i]);
		}
		System.out.println();
		for(int z = 0 ; z < x.length ; z++) {
			x[z] += 32;
			System.out.print((char)x[z]);
		}
		
	}			
}