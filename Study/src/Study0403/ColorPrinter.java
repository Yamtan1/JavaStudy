package Study0403;

public class ColorPrinter implements Printable {

	@Override
	public void print(Document doc) {
		System.out.println("컬러로 프린트 합니다");
		System.out.println(doc.n);
		
	}

}
