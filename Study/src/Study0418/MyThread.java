package Study0418;

public class MyThread extends Thread {
	//프로세스는 하나이상의 스레드를 받는다
	//스레드는 프로그램이 동작하는데 있어서 필요한 하나의 흐름
	//멀티스레드는 하나의 프로그램 안에 여러개의 스레드가 존재할 수 있다.
	
	//스레드를 만드는법 
	//1.스레드 클래스를 상속받는 방법 : 다른 방법을 더 선호함. 클래스는 하나의 상속만을 받을 수 있는데 스레드를 상속 받으면 다른 상속을 못받기때문
	//2.인터페이스로 구현하는 방법 : 인터페이스는 여러개 상속받을 수 있으므로 해당 방법을 선호함.
	
	@Override
	public void run() {
		for(int i =0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i); //currentThread(): 현재실행중인 스레드를 뜻함.
			
			try {
				Thread.sleep(1000); //1초간 스레드를 잠재운다는 뜻. 1000 = 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
