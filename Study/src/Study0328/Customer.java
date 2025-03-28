package Study0328;

public class Customer {
	private String name;
	private int grade;
	private int money;
	
	Customer(){}
	
	public Customer(String name, int grade, int money) {
		this.name = name;
		this.grade = grade;
		this.money = money;
	}
	public void ride(Bus x) {
		this.money = this.money - 1000;
		x.take(1000);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
	public void showInfo() {
		System.out.println("손님정보 [name=" + name + ", grade=" + grade + ", money=" + money + "]");
	}

	
	
}
