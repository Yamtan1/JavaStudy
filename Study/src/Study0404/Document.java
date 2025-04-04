package Study0404;

import java.util.Scanner;

public class Document {
	private String n;
	Scanner sc = new Scanner(System.in);
	Printable printer;
	public String getN() {
		return n;
	}

	public void setN() {
		
		String n = "";
		System.out.println("프린트할 문서를 작성하세요!");
		while(true) {
			String s = sc.nextLine();
			
			if(s.equals("END")) {
				System.out.println("문서작성이 완료되었습니다.");
				break;
			}
			n = n + "\n" + s;
		}
		this.n = n;
	}
	
	/* public void select() {
		
	System.out.println("컬러프린트, 흑백프린트를 선택해주세요");
	System.out.print("color 또는 black 입력하세요. 입력>>>>");
	String input = sc.nextLine();
	
	if(input.equals("color")) {
		printer = new ColorPrinter();	
		
	}
	else if(input.equals("black")){
		printer = new BlackPrinter();
	}
	printer.print(Document.this);

	} */
}
