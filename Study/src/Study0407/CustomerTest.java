package Study0407;

public class CustomerTest {

	public static void main(String[] args) {
		
		Customer p1 = new Customer(1,"김미자","010-1234-5679", 500000);
		
		System.out.println(p1);
		
		p1.buy(1000000);
		System.out.println(p1);
		
		
	}

}
