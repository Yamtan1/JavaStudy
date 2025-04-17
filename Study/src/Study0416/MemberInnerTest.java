package Study0416;

public class MemberInnerTest {

	public static void main(String[] args) {
		
		Outer1 out = new Outer1();
		
		out.getUnit();
		
		Outer1.MemberInner1 inner = out.new MemberInner1(); //참조변수를 참조해서 생성함
		inner.move();
		

	}

}
