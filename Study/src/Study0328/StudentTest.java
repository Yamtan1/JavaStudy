package Study0328;

public class StudentTest {

	public static void main(String[] args) {
		
		Personal h1 = new Personal("홍길동","150328-3******",'M');
		
		Student s1 = new Student(h1, 3, 10, 45);
		
		
		System.out.println(s1);

	}

}
