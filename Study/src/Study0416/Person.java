package Study0416;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Person implements Comparable<Person>{
	
	private String name;
	private int age;
	@Override
	public int compareTo(Person o) {
		System.out.println(this.age - o.age);
		//return this.age - o.age; //오름차순
		return this.age - o.age; //내림차순
	}
}
