package Study0418;

public class MyRunnable implements Runnable {
	//스레드를 만드는법 
	//2.인터페이스로 구현하는 방법 : 인터페이스는 여러개 상속받을 수 있으므로 해당 방법을 선호함.
	@Override
	public void run() {
		for(int i = 0; i <10 ; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
