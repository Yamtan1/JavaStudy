package Study0414;

import java.util.Objects;

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
public class Rectangle implements Cloneable{
	
	private Point upperLeft;
	private Point lowerRight;
	
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		upperLeft = new Point(x1, y1);
		lowerRight = new Point(x2, y2);
	}
	
	public void changePos(int x1, int y1, int x2, int y2) {
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
	}
	
	public void showPosition() {
		System.out.print("좌측 상단 : ");
		upperLeft.showPosition();
		
		System.out.print("우측 하단 : ");
		lowerRight.showPosition();
		System.out.println();
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Rectangle copy = (Rectangle) super.clone();
		copy.upperLeft = (Point) upperLeft.clone();
		copy.lowerRight = (Point) lowerRight.clone();
		return copy;
	}
	@Override
	public int hashCode() {
		return Objects.hash(upperLeft, lowerRight); 
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)  
			return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		
		Rectangle target = (Rectangle) obj;
		return upperLeft.equals(target.upperLeft) && lowerRight.equals(target.lowerRight);
	
	}
}
