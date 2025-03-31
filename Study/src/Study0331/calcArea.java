package Study0331;

public class calcArea {
	// instanceof 누구로 부터 나온 인스턴스 인가
	
	static void calcArea(Diagram shape) {
		if(shape instanceof Quadrilateral) {
			Quadrilateral q =(Quadrilateral)shape;
			System.out.println(q.name + "사각형의 넓이는 : " + q.bottom*q.height);
		}
		else if(shape instanceof Triangle){
			Triangle t = (Triangle)shape;
			System.out.println(t.name + "삼각형의 넓이는 : " + (double)(t.bottom*t.height) / 2);
		}
		else if(shape instanceof Circle){
			Circle c = (Circle)shape;
			double x = c.radius*c.radius*c.pi;
			System.out.println(c.name + "원의 넓이는 : " + x );
		}
	}
	
	
	void calcarea(Triangle triangle) {
		
	}
	void calcarea(Quadrilateral quadrilateral) {
		
	}
	void calcarea(Circle circle) {
		
	}
}
