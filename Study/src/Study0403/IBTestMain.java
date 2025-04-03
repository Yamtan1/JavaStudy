package Study0403;

public class IBTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IB ib = new B();
		IB ib2 = new C();
		
 		IB[] arr = new IB[2];	
 		arr[0]=ib;
 		arr[1]=ib2;
 		
 				
 		
 		for(int i = 0; i <arr.length; i++) {
 			arr[i].f1();
 			arr[i].f2();
 		}
	}

}
// 인터페이스는 타입으로 존재한다. 