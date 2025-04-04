package Study0404;

import java.util.Scanner;

public class TvUser {

	public static void main(String[] args) {
		
		System.out.println("어떤 브랜드의 TV를 원하십니까");
		System.out.print("samsung과 lg 브랜드가 있습니다. 선택하세요 >>");
		
		BeanFactory factory = new BeanFactory();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		TV tv3 = factory.getBean(input);  //매개변수에 "samsung"이 주입되면 삼성티비 매개변수에 "LG"가 주입되면 LG티비가 작동되게 하시오
		if( tv3 != null) {
		tv3.powerOn();
		tv3.volumeUp();
		tv3.volumeDown();
		tv3.powerOff();
		}
		else {
			System.out.println("잘못입력하셨습니다.");
		}
	}
}
