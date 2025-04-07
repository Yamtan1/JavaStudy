package Study0407;

public class ArrPlus {
	
	private int index;
	private Object[] o1;
	
	
	
	public ArrPlus(){
		o1 = new Object[5];
	}
	public void add(Object n) {
		if(index < o1.length) {
			o1[index++] = n;
		}
		else {
			Object[] temp = new Object[o1.length+5];
			for(int i = 0; i < o1.length; i++) {
				temp[i] = o1[i];
				
			}
			o1 = temp;
			o1[index++] = n;
		}
	}
	
	public void print() {
		for(int i = 0; i < o1.length; i++) {
			System.out.println(o1[i]);
		}
	}
	public Object[] getO1() {
		return o1;
	}
	public void setO1(Object[] o1) {
		this.o1 = o1;
	}
	
}
