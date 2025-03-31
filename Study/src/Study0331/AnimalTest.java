package Study0331;

public class AnimalTest {

	public static void main(String[] args) {
		
		Animal[] arr = new Animal[3];
		
		Cat c1 = new Cat();
		Dog d1 = new Dog();
		Tiger t1 = new Tiger();
		
		c1.Cry();
		d1.Cry();
		t1.Cry();
		
		arr[0] = c1;
		arr[1] = d1;
		arr[2] = t1;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i].Cry();
		}
 		
	}

}
