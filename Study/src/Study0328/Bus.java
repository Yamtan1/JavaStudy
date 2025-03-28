package Study0328;

public class Bus {
	
	private int busNum;
	private int customerNum;
	private int takeMoney;
	
	Bus(){}
	
	public Bus(int busNum) {
		this.busNum = busNum;
	}
	public void take(int price) {
		customerNum++;
		this.takeMoney = this.takeMoney + price; 
	}

	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}

	public int getTakeMoney() {
		return takeMoney;
	}

	public void setTakeMoney(int takeMoney) {
		this.takeMoney = takeMoney;
	}

	
	public void showInfo() {
		System.out.println("버스정보 [busNum=" +  + busNum +  ", customerNum=" + customerNum + ", takeMoney=" + takeMoney + "]"); 
	}
	
}
