package Study0313;

public class Switch0313 {

	public static void main(String[] args) {
		// 점수에 따라서 학점을 구한다.
		// 점수가 90 ~ 100점 : A학점, 80~89: B학점, 70~79 : C학점, 60~69: D학점, 59이하는 F학점
		int score = 60;
		
		switch(score / 10) {
		
		case 10 :    
		case 9 : System.out.println("A"); break;
		case 8 : System.out.println("B"); break;
		case 7 : System.out.println("C"); break;
		case 6 : System.out.println("D"); break;
		default : System.out.println("F"); break;
			
		}

	}

}
