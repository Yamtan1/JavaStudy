package Study0418;

enum Scale1 { //인터페이스를 통한 상수처리를 enum으로 바꾼것
	DO, RE, MI, FA, SO, RA, TI
}
public class SimpleEnumTest {
	
	public static void main(String[] args) {
		
		Scale1 sc = Scale1.DO;
		System.out.println(sc);
		
		switch(sc) {
			case DO:
				System.out.println("도");
				break;
			case RE:
				System.out.println("레");
				break;
			case MI:
				System.out.println("미");
				break;
			case FA:
				System.out.println("파");
				break;
			case SO:
				System.out.println("솔");
				break;
			case RA:
				System.out.println("라");
				break;
			case TI:
				System.out.println("시");
				break;
			default:
				System.out.println("솔~,라~,시~");
				break;
		}
		
	}

}
