package Study0331;

public class Quadrilateral extends Diagram {
	int bottom=10;
	int height=5;
	String name;

	Quadrilateral(String quadrilateral){
		this.name = quadrilateral;
	}
	/* Quadrilateral(int bottom,int height) {
		this.bottom=bottom;
		this.height=height; */
	Quadrilateral(int height, int bottom, String name){
		this.height=height;
		this.bottom=bottom;
		this.name=name;
	}
	/*void area() {
		System.out.println("사각형의 넓이는 : " + this.bottom*this.height);
	} */
	
}


