package Study0331;

public class DiagarmTest {

	public static void main(String[] args) {
		/* 클래스 3개
		사각형 클래스
		삼각형 클래스
		원 클래스 

		면적을 구하는 함수

		실행클래스에서 반복문을 써서 3개의
		원과 사각형 삼격형 면적을출력 */

		Diagram[] arr = new Diagram[3];

		arr[0] = new Circle("원");
		arr[1] = new Triangle("삼각형");
		arr[2] = new Quadrilateral("사각형");

		for(int i = 0; i < arr.length; i++){
			calcArea.calcArea(arr[i]);
		}

		Diagram[] arr2 = new Diagram[3];
		Circle c2 = new Circle(3.141592, 5, "두번째 원");
		Triangle t2 = new Triangle(15,3,"두번째 삼각형");
		Quadrilateral q2 = new Quadrilateral(2, 5, "두번째 사각형");
		arr2[0] = c2;
		arr2[1] = t2;
		arr2[2] = q2;

		for(int x = 0; x< arr2.length; x++){
			calcArea.calcArea(arr2[x]);
		}
		calcArea cal1 = new calcArea();
		cal1.calcArea(c2);

		/* Quadrilateral q1 = new Quadrilateral(5, 10);
		Triangle t1 = new Triangle(5, 9);
		Circle c1 = new Circle(3.141592, 8); */
		
		/* arr[0] = q1;
		arr[1] = t1;
		arr[2] = c1; */
		
		

		
	}

}
