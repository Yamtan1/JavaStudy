package Study0418;

public enum Grade {
	GOLD("골드", 0.1),  // 괄호안에 있는게 멤버상수
	SILVER("실버", 0.05),
	BRONZE("브론즈", 0.02);
	
	private final String korName;
	private final double discountRate;
	
	Grade(String korName, double discountRate){
		this.korName = korName;
		this.discountRate = discountRate;
	}
	
	public double calculateDiscount(int price) {
		double result = price * discountRate;
		return result;
	}

	public String getKorName() {
		return korName;
	}

	public double getDiscountRate() {
		return discountRate;
	}
}
