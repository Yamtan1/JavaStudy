package Study0404;

import java.util.Scanner;

public class PrinterSelect {

	Scanner sc = new Scanner(System.in);
	Printable printer;
	public void select(Document doc) {
		
	System.out.println("컬러프린트, 흑백프린트를 선택해주세요");
	System.out.print("color 또는 black 입력하세요. 입력>>>>");
	String input = sc.nextLine();
	
	if(input.equals("color")) {
		printer = new ColorPrinter();	
		
	}
	else if(input.equals("black")){
		printer = new BlackPrinter();
	}
	printer.print(doc);
}
}
