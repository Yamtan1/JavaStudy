package Study0403;

public class TvUser {

	public static void main(String[] args) {
		SamsungTv
		s1 = new SamsungTv();
		s1.powerOn();
		s1.powerOff();
		s1.volumeUp();
		s1.volumeDown();
		
		/* LgTv l1 = new LgTv();
		l1.turnOn();
		l1.turnOff();
		l1.soundUp();
		l1.soundDown(); */
		
		TV tv1 = new SamsungTv();
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		tv1.powerOff();
		
		TV tv2 = new LgTv();
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();
		/* tv= new LgTv();
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff(); */
		
		TV[] tvs = new TV[2];
			tvs[0] = tv1;
			tvs[1] = tv2;
			
		for(int i =0 ; i < tvs.length; i++) {
			tvs[i].powerOn();
			tvs[i].powerOff();
			tvs[i].volumeUp();
			tvs[i].volumeDown();	
		}	
		
		BeanFactory factory = new BeanFactory();
		TV tv3 = factory.getBean(1); //1이면삼성티비 2이면 엘지 티비가 작동되게 하시요
		if( tv3 != null) {
		tv3.powerOn();
		tv3.volumeUp();
		tv3.volumeDown();
		tv3.powerOff();
		}
		else {
			System.out.println("잘못입력하셨습니다.");
		}
	}
}
