package Study0317;

public class Function0317 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =add3(10); // 함수 호출문, 함수란걸 알려주기 위해 반드시 괄호를 입력해야함.
		System.out.println(x);
	}
	public static int add3(int n) {
		int result = n + 3;
		return result;		
	}
}