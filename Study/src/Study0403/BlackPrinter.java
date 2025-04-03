package Study0403;

public class BlackPrinter implements Printable{

	@Override
	public void print(Document doc) {
		System.out.println("흑백으로 프린트 합니다.");
		System.out.println(doc.n);
		
	}

}
