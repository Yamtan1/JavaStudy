package Study0328;

public class Robot {
	
	private String name;
	private static int feeling;
	
	public Robot(String name, int feeling) {
		this.name = name;
		this.feeling = feeling;
	}
	
	public static void setFeeling(int feeling) {
		Robot.feeling = feeling;
	}

	public static int getFeeling() {
		return feeling;
	}

	public void complimnet() {
		if(this.feeling <10) {
		feeling++;	
		}
		if(7 <= this.feeling) {
			System.out.println("하늘을 나는 기분이에요");
		}
		
	}
	public void scold(){
		feeling--;
		feeling--;
		if(this.feeling <= 1) {
			feeling=1;
		}
		
		
		
	}

	@Override
	public String toString() {
		return "Robot [name=" + name + "로봇의 현재 기분은 " + feeling + "입니다." + "]";
	}
}
