package vo;

public class Person0327 {
	/* 휴먼클래스 활용
인간은 고유번호가 있음 num 중복되면안됨 사람마다 다 달라야함.
번호는 인스턴스가 생성될때 자동으로 할당되게 끔 만들어라
메인메서드에서 인간이 몇명만들어졌는지 알 수 있게 끔 처리.
추가문제 성별을 집어넣을거임 남자 m 여자 f
인스턴스를 10개만드는데 기본생성자는 없음.
남자 4명 여자 6명 생성 얘네를 배열에다넣고
남자는 몇명 여자는 몇명 출력되게  */
	public static int cnt; // 클래스 변수로 인간의 총 수를 구하는데 사용할 예정임.
	private int id; // 고유번호
	private char gender;
	
	
	public Person0327(){
		id = ++cnt;
		System.out.println("고유번호 : " + id + ", 인구수 : " + cnt);
	}

	public int getId() {
		return id;
	} 
	
	public char getGender() {
		return gender;
	}
	public Person0327(char gender){
		id = ++cnt;
		this.gender=gender;
		System.out.println("고유번호 : " + id + ", 인구수 : " + cnt + " ,성별 : " + this.gender);
	}


}
