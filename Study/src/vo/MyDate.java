package vo;

public class MyDate {
	private int year;
	private int month;
	private int day;
	/* 클래스이름 MyDate
	멤버변수는 년도 월 일 타입은 전부 int 날짜정보를 저장하는 vo객체
	년도는 제한이 없음 월은 1~12 일은 28 29 30 31  28 29일은 2월에 해당 */
	
	MyDate() {}
	
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		 
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		int result = checkMonth(month);
		this.month = result;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		if(this.month == 2 && this.year / 4 == 0 && day <= 29 && 1 <= day) {
			this.day = day;
		}
		else {
			System.out.println("범위를 벗어 났습니다");
		}
	}
	private int checkMonth(int month) {
		if(1 <= month && month <= 12) {
			return month;
		}
		else {
			System.out.println("범위를 벗어났습니다");
			return 0;
		}
	}
}
