package Study0328;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Member m1 = new Member();		
		m1.setId("abd123");
		m1.setName("홍길동");
		m1.setAdress("서울시 영등포구 여의동도 20번지");
		
		Order o1 = new Order(202503280001L, "2025년 3월 28일", "PD0345-12", m1);
		
		System.out.println(o1);
		
		
	}

}
 