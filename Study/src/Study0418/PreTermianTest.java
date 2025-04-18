package Study0418;

import java.util.stream.IntStream;

public class PreTermianTest {

	public static void main(String[] args) {
		
		int sum = IntStream.of(1, 3, 5, 7, 9)
				  .sum();
		System.out.println("sum : " + sum);
		
		long count = IntStream.of(1, 3, 5, 7, 9)
					 .count();
		System.out.println("count : " + count);
	}
}
