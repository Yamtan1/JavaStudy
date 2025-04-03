package Study0403;

public class PrintTest {

	public static void main(String[] args) {
		Printable a1 = new ColorPrinter();
		Printable a2 = new BlackPrinter();
		Document d1 = new Document("아아ㅏ아아아아아아ㅏ아아!!!!");
		a1.print(d1);
		a2.print(d1);
	}

}
