package Study0401;

public class MouseTest {

	public static void main(String[] args) {
		Mouse[] arr = new Mouse[3];
		
		Mouse m = new Mouse();
		wheelMouse wm = new wheelMouse();
		OpticalMouse om = new OpticalMouse();
		
		arr[0] = m;
		arr[1] = wm;
		arr[2] = om;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i].clickLeft();
			arr[i].clickRight();
			if(arr[i] instanceof wheelMouse) {
				wheelMouse x = (wheelMouse)arr[i];
				x.scroll();
			}
		}
		for(int i = 0; i < arr.length; i++) {
		if(arr[i].getClass() == wheelMouse.class) { // 휠마우스 클래스만 스크롤 함수 를 실행시키는 코드 
			wheelMouse x2 = (wheelMouse)arr[i];
			x2.scroll();
		}
		}
		//배열의 요소가 마우스타입인지 마우스의 인스턴스면 마우스입니다 휠마우스면 휠마우스입니다.
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] instanceof OpticalMouse) {
				System.out.println("옵티컬 마우스 입니다.");
			}
			
			else if(arr[i] instanceof wheelMouse) {
				System.out.println("휠 마우스 입니다.");
			}
			else if(arr[i] instanceof Mouse) {
				System.out.println("마우스 입니다.");
			}
		}
	}

}
