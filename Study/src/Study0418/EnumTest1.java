package Study0418;

enum DAY{
	MONDAY, THUSDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
public class EnumTest1 {

	public static void main(String[] args) {
		DAY today = DAY.FRIDAY;
		for(DAY day : DAY.values()) {
			System.out.println(day);
		}
		System.out.println(today);
		switch(today) {
		case MONDAY -> System.out.println("한 주가 시작되었군");
		case THUSDAY -> System.out.println("언제 오나 주말");
		case WEDNESDAY -> System.out.println("오늘만 가면 2일 남았다");
		case THURSDAY -> System.out.println("이제 내일만");
		case FRIDAY -> System.out.println("이제 오늘만");
		case SATURDAY -> System.out.println("퇼");
		case SUNDAY -> System.out.println("ㅇ");
		default -> System.out.println("그런 요일 없어요");
		}	
	
	}

}
