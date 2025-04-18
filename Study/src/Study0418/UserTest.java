package Study0418;

public class UserTest {

	public static void main(String[] args) {
		/* 
		회원클래스를 만드시오.   클래스이름은 User

		회원의 멤버변수는  회원번호, 이름, 성별, 회원등급 입니다.
		성별은 남자 (MALE) 여자(FEMALE) 되어있습니다.
		회원등급은 골드(GOLD), 실버(SILVER), 브론즈(BRONZE)로 되어있습니다
		회원등급이 골드인 회원은 할인율이 10% 적용됩니다 
		회원등급이 실버인 회원은 할인율이 5% 적용됩니다
		회원등급이 브론즈인 회원은 할인율이 2%적용됩니다
		
		회원등급을 enum으로 만드시오
		enum의 멤버상수는 
		korName(String), discountRate(double)로 한다.
		실행 클래스를 만들어  골드, 실버, 브론즈 회원을
		테스트하시오.
		 */
		User u1 = new User(001,"홍길동",Gender.Male, Grade.GOLD);
		int fee = 190000;
		
		u1.pay(fee, Grade.GOLD);

	}

}
