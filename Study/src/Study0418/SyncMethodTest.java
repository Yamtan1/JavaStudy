package Study0418;

public class SyncMethodTest {
	public static int money = 0;
	public static void main(String[] args) throws InterruptedException {
		//synchronized : 스레드가 실행중일때 다른스레드가 접근하지 못하게함(동기화 / 비동기화)
		Runnable task1 = () -> {
			for(int i =0; i<10000; i++) {
				deposit();
			}
		};
		Runnable task2 = () -> {
			for(int i =0; i<10000; i++) {
				withdraw();
			}
		};
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(money);
	}
	
	public synchronized static void deposit() {
		money++;
	}
	public synchronized static void withdraw() {
		money--;
	}
	
}
