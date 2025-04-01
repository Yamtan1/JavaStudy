package Study0401;

public class MyIntArray {
	
	private int[] arr;
	//기본생성자를 써서 정수를 5개 저장할 수 있는 배열을 멤버변수에 할당
	//getter역할을 하는 메서드를 하나 만들고 특정한 요소값을 외부로 반환해야함 
	//특정한 요소에다가 값을 저장하는 setter용 함수를 하나 만듬
	//배열에 저장되어있는 모든값을 출력해주는 함수도 만들기
	
	public MyIntArray(){
		arr = new int[5];
	}
	public void arraySet(int index, int num) {
		arr[index] = num;
	}
	public int arrayGet(int index) {
		int result = arr[index];
		return result;
	}
	public void arrayPrint() {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
