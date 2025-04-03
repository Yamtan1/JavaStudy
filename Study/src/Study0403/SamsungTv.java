package Study0403;

public class SamsungTv implements TV{
	@Override
	public void powerOn() {
		System.out.println("SamsungTV 전원 켠다.");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV 전원 끈다.");
	}
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV 소리 키우기.");
	}
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV 소리 줄이기.");
	}
	/* @Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		
	} */
}
