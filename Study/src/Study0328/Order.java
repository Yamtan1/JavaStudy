package Study0328;

public class Order {

	private long num;
	
	private String date;
	
	private String goodsnum;
	
	private Member member;

	
	Order(){}
	
	public Order(long num, String date, String goodsnum, Member member){
		this.num = num;
		this.date = date;
		this.goodsnum = goodsnum;
		this.member = member;
		
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		member = member;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}



	public String getGoodsnum() {
		return goodsnum;
	}

	public void setGoodsnum(String goodsnum) {
		this.goodsnum = goodsnum;
	}

	
	@Override
	public String toString() {
		return "Order [주문번호=" + num + ", 주문자 아이디=" + member.getId() + ", 주문날짜=" + date + ", 주문자 이름=" + member.getName() + ", 주문상품번호=" + goodsnum
				+ ", 배송주소=" + member.getAdress() + "]";
	}


	
	
	
	
}
