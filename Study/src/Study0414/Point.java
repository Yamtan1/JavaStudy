package Study0414;

//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;

import java.util.Objects;

//@Getter
//Setter
//@EqualsAndHashCode
public class Point implements Cloneable{ //clone 함수를 사용하기 위해선 Cloneable 인터페이스를 연결해야함 
										 //마커(표시용) 인터페이스라고 함. 생성안했는데도 사용가능
	private int xPos;
	private int yPos;
	
	public Point(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
	}

	public int getXPos() {
		return xPos;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	public void showPosition() {
		System.out.printf("[%d,%d]", xPos, yPos);
		System.out.println();
	}
	@Override//오버라이딩 할때 범위가 좁아질순 없지만 더 넓어질 순 있음
	public Point clone() throws CloneNotSupportedException {
		
		return (Point)super.clone();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return xPos == point.xPos && yPos == point.yPos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(xPos, yPos);
	}

	public void changePos(int x, int y) {
		xPos = x;
		yPos = y;	
	}
}
