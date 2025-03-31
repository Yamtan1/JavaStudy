package Study0331;

public class Circle extends Diagram {
	double pi=3.14;
	double radius=10;
	String name;

	Circle(String circle){
		this.name=circle;
	}
	Circle(double pi, double radius, String name){
		this.pi = pi;
		this.radius = radius;
		this.name = name;
	}
	
	/* Circle(double pi, double radius) {
		this.pi = pi;
		this.radius=radius; */
	}
	/*void area() {
		double x = this.radius*this.radius*this.pi;
		System.out.println("원의 넓이는 : " + x ); 
	}*/


