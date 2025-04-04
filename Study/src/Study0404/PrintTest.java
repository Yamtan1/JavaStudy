package Study0404;

import java.util.Scanner;

public class PrintTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		Printable a1 = new ColorPrinter();
		Printable a2 = new BlackPrinter();
		Document d1 = new Document();
		
		d1.setN();
		PrinterSelect ps = new PrinterSelect();
		ps.select(d1);
		//d1.select();
	}

}
