package Study0401;

public class MyIntArrayTest {

	public static void main(String[] args) {
		
		MyIntArray arr = new MyIntArray();
		
		arr.arraySet(0, 12);
		arr.arraySet(1, 26);
		arr.arraySet(2, 58);
		arr.arraySet(3, 90);
		arr.arraySet(4, 17);
		
		System.out.println(arr.arrayGet(0));
		System.out.println(arr.arrayGet(1));
		System.out.println(arr.arrayGet(2));
		System.out.println(arr.arrayGet(3));
		System.out.println(arr.arrayGet(4));
		
		arr.arrayPrint();
		

	}

}
