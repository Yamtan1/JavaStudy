package Study0402;

public class MyIntArray2 {
	
	private int[] arr;
	private int idx;
	//기본생성자를 써서 정수를 5개 저장할 수 있는 배열을 멤버변수에 할당
	//getter역할을 하는 메서드를 하나 만들고 특정한 요소값을 외부로 반환해야함 
	//특정한 요소에다가 값을 저장하는 setter용 함수를 하나 만듬
	//배열에 저장되어있는 모든값을 출력해주는 함수도 만들기
	
	public MyIntArray2(){
		arr = new int[5];
	}
	public void add(int value) {
		if(idx < arr.length) {
			arr[idx++] = value;	
		}
		else {
			int[] temp = new int[arr.length + 5];
			for(int x = 0; x < arr.length; x++) {
				temp[x] = arr[x];
			}
			arr = temp;
			arr[idx++] = value;
		}
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
	public void deleteInt(int index) {
		for(int i =0 ; i < arr.length -1; i++) {
			if(i == index) {
				arr[i] = arr[i+1];
				index++;
			}
			System.out.println(arr[i]);
		}
		
	}
	public void addInt(int n) {
		for(int i = 0 ; i < arr.length; i++) {
			if(i == arr.length-1) {
				arr[i] = n;	
			}
		}
	}
	public void plusIndex() {
		
		int[] arr2 = new int[arr.length+5];
		for(int x = 0; x < arr.length; x++) {
			arr2[x] = arr[x];
			}
			arr = arr2;			
		}
	
	public void insertion(int n, int index) {
		for(int i = arr.length -1; 0 <= i; i--) {
			arr[i] = arr[i-1]; 
			if(i == index) {
				break;
			}
		}
		arr[index] = n;
		
		
	}
	}

