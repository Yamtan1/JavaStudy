package Study0418;

public class MyThreadTest {

	public static void main(String[] args) {
		//☆☆☆☆run메서드를 직접호출하면 실행을 하지 않음. start메서드로 호출해야하고 호출하면 run메서드가 실행됨.☆☆☆☆☆
		//run메서드는 클래스파일에 오버라이딩 필수!!!! 스레드 상속도 필수!!!!!!!!!!!!!
		
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		t1.setName("Thread-A");
		t2.setName("Thread-B");
		//두 개의 스레드가 동시에 진행됨.
		
		t1.start();
		t2.start();
		
		System.out.println("------End of Main-------");
		//메인(psvm) 스레드와 우리가만든 A스레드가 공존하는 상태임
		//메인스레드는 본인의 작업을 끝냄 그전에 A스레드는 실행되었고 마지막 프린트문이 먼저 출력 된거임.
	}

}
