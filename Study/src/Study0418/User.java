package Study0418;

import lombok.Data;

@Data
public class User {

	private int no;
	private String name;
	private Gender gender;
	private Grade grade;
	
	User(int no, String name, Gender gender, Grade grade){
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.grade = grade;
	}
	
	public void pay(int price,Grade grade) {
		int fee = price - (int)grade.calculateDiscount(price);
		System.out.println(grade.getKorName() + "회원 " + name + "은(는) " + fee + "을 지불했습니다");
		System.out.println(">>> price : " + price + "," + " discountCost : " + (int)(price * grade.getDiscountRate()));
	}
}
