package Study0326;

import vo.Human;

public class HumanTest {

	public static void main(String[] args) {
		
		Human info = new Human();
		Human info2 = new Human();
		Human info3 = new Human();
		Human info4 = new Human();
		
		
		info.setName("James");
		info.setAge(50);
		System.out.println(info);
		
		info2.setName("Ann");
		info2.setAge(8);
		System.out.println(info2);
		
		info3.setName("Bread");
		info3.setAge(300);
		System.out.println(info3);
		
	
		System.out.println(info4);
		
		Human info5 = new Human(201, "Dddd");
		System.out.println(info5);
		
		//boolean a = info2.ageveri(); boolean으로 내가적은거
		//System.out.println(a);
	}

}
/* 사람(Human) 클래스를 만드시오.

사람은 아무정보도 없는 상태로 존재할 수 있습니다. 변수만 지정

생성된 후 이름과 나이를 부여 받습니다. setter

이때 나이는 1살 부터 200살 사이의 값이어야 합니다.
만일 나이가  범위 밖의 값으로 부여된다면
'값의 허용범위를 벗어났어요' 라는 메세지를 콘솔에 출력합니다.
그리고 나이는 자동으로 0살로 세팅됩니다.

사람객체(인스턴스)의 정보(이름, 나이)를 하나의 문자열로 구성할 때
나이가 0살이면 나이값은 '미정'이라고 해주십시오

--------------------------------------------------------------------------
두번째 문제
나이를 검증하는 기능을 별도의 함수로 만드시오.
또한, 그 함수는 해당 클래스의 멤버 만 사용할 수 있습니다. */