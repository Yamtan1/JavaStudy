package Study0404;

public class Person extends Parents implements Me, Speak, Run {

	@Override
	public void running() {
		System.out.println("열심히 달립니다");
		
	}

	@Override
	public void speakEng() {
		System.out.println("영어로 말합니다");
		
	}

	@Override
	public void learnJava() {
		System.out.println("자바를 배웁니다.");
		
	}
	

}
