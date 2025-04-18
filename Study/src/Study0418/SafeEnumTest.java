package Study0418;
enum Animal1{
	DOG, CAT
}

enum Person1{ 
	MAN, WOMAN
}
public class SafeEnumTest {

	public static void main(String[] args) {
		
		who(Person1.MAN);

	}
	public static void who(Person1 man) {
		switch(man){
		case MAN:
			System.out.println("남성손님입니다.");
			break;
		case WOMAN:
			System.out.println("여성손님입니다.");
			break;
	}
	}

}
