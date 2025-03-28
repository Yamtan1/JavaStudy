package Study0328;

public class BusCustomerTest {

	public static void main(String[] args) {
		
		Customer s1 = new Customer("홍길동", 3, 10000);
		Customer s2 = new Customer("임꺽정", 5, 10000);
		Customer s3 = new Customer("춘향", 6, 10000);
		
		
		Bus b1 = new Bus(86);
		Bus b2 = new Bus(87);
		s1.ride(b1);
		s2.ride(b1);
		s2.ride(b2);
		s3.ride(b2);
		s3.ride(b1);
		b1.showInfo();
		b2.showInfo();
		s1.showInfo();
		s2.showInfo();
		s3.showInfo();
		
	}

}
