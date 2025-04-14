package Study0414;

import java.util.HashSet;
import java.util.Set;

public class RectangleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle org = new Rectangle(1, 1, 9, 9);
		
		Rectangle cpy;
		
		
		try {
			cpy = (Rectangle)org.clone();
			org.showPosition();
			cpy.showPosition();
			Set<Rectangle> set = new HashSet<>();
			set.add(org);
			set.add(cpy);
			System.out.println(set.size());
			
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		
		
		/* try {
			cpy =(Rectangle)org.clone();
			org.showPosition();
			cpy.showPosition();
			cpy.changePos(2, 2, 8, 8);
			org.showPosition();
			cpy.showPosition();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} */

		
	}

}
