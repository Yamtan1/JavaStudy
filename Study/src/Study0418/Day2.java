package Study0418;

public enum Day2 {
	MONDAY("월요일","Monday"),
	TUESSDAY("화요일", "Tuesday"),
	WEDNESDAY("수요일", "Wednesday"),
	THUSDAY("목요일", "Thusday"),
	FRIDAY("금요일", "Friday"),
	SATURDAY("토요일", "Saturday"),
	SUNDAY("일요일", "Sunday");
	
	private final String korName;
	private final String engName;
	
	Day2(String korName, String engName){
		this.korName = korName;
		this.engName = engName;
	}

	public String getKorName() {
		return korName;
	}

	public String getEngName() {
		return engName;
	}
}
