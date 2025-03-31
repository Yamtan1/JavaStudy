package Study0331;

public class Triangle extends Diagram {
	int height=10;
	int bottom=5;
	String name;

	Triangle(String triangle) {
		this.name = triangle;
	}
	Triangle(int height, int bottom, String name){
		this.height=height;
		this.bottom=bottom;
		this.name=name;
		}
	/* Triangle(int bottom,int height) {
		this.bottom=bottom;
		this.height=height;
	}*/
	
	/*void area() {
		System.out.println("삼각형의 넓이는 : " + (double)(this.bottom*this.height) / 2); 
	} */
}
