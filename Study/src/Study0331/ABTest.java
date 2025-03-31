package Study0331;

public class ABTest {

	public static void main(String[] args) {
		
		/* A a = new A();
		B b = new B();
		a.n=10;
		a.fa();
		b.fb();
		b.fa();
		b.n=11;
		
		A ab = new B();  
		// B ba = new A();  반대로 하면 안됨!
		B bb = (B)ab;
		bb.k=40;
		bb.fa(); */
		
		//Student s1 = new Student();
		//Worker w1 = new Worker();
		Human[] humans = new Human[3];
		Student[] students = new Student[3];
		Worker[] workerss = new Worker[3];
		
		Human h1 = new Human();
		Student s1 = new Student(); 
		Worker  w1 = new Worker();
		
		humans[0] = h1;
		humans[1] = s1;
		humans[2] = w1; // 상속을 통해 다른 타입에 자료형도 배열에 넣을 수 있음.
		
		Student x = (Student)humans[1]; // 형변환을 통해 자식 클래스의 요소들에 대해 접근 가능
		
		B b = new B();
		b.fa();
		A a = new B();
		a.fa(); //상속된 클래스 간 같은 메서드가 있다면 자식 요소의 메서드가 실행된다.
		
	 }

}
