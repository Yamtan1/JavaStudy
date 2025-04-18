package Study0418;

public class FinallyTest {

	public static void main(String[] args) {
		System.out.println("-------Start------");
	
		try{//해야할 일 (기능)
			String s = "abc";
			System.out.println(s.charAt(0));
		} catch(NullPointerException e) {
			//문제가 생기면 문제가 생겼다고 알려주고 프로그램은 지속되어야 한다.
			System.out.println("s에 문자열이 담겨있지 않아요.");
		}finally {
			System.out.println("반드시... 해야 할 일을 하지");
		}
		System.out.println("----------End----------");
		
		

	}

}
