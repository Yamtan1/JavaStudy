package Study0407;

public class Customer {
	private int num;
	private String name;
	private String pn;
	private int price;
	private int point;
	
	Customer(int num, String name, String pn, int price){
		this.num = num;
		this.name = name;
		this.pn = pn;
		this.price = price;
		point = 0;
		if(1000000 < price) {
			point = (int)(price * 0.05);
			System.out.println("100만원 초과로 VIP고객으로 전환되었습니다.");
		}
	}
	public void buy(int buyPrice) {
		price = price + buyPrice;
		if(1000000 < price) {
			point = (int)(buyPrice * 0.05);
			System.out.println("현재 포인트는" + point + "입니다.");

		}
	}
	

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPn() {
		return pn;
	}


	public void setPn(String pn) {
		this.pn = pn;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		if(1000000 < price) {
			
			return "고객정보 [고객번호: v" + num + ", 이름=" + name + ", 전화번호=" + pn + ", 구매금액=" + price + ", 현재포인트=" + point + "]";	
		}
		else {
			return "고객정보 [고객번호: c" + num + ", 이름=" + name + ", 전화번호=" + pn + ", 구매금액=" + price + ", 현재포인트=" + point + "]";
		}
			
		
	}
	
}
