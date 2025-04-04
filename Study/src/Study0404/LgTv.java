package Study0404;

public class LgTv implements TV {
	
	@Override
	public void powerOn() {
		System.out.println("LgTV 전원 켠다.");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV 전원 끈다.");
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV 소리 키우기.");
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV 소리 줄이기.");
	}
	/* @Override
	public void powerOn() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		
	} */
}
