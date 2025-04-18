package Study0418;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		
		try {
			FileWriter fw = new FileWriter("C:/Temp/jv_test/test1.txt");
			fw.write("Hello, Java File I/O를 연습중입니다.");
			fw.close(); // 데이터베이스의 commit과 같은느낌 반드시 써야함
			
			System.out.println("파일에 문자열을 성공적으로 썼습니다.");
			
			fw = new FileWriter("C:/Temp/jv_test/test.txt", true); //true가 있으면 이어쓰기가 가능함 없으면 덮어쓰기임
			fw.write("\n이어서 씁니다. Hello, Java File I/O를 연습중입니다.\n");
			fw.close(); // 데이터베이스의 commit과 같은느낌 반드시 써야함
			
			System.out.println("파일에 문자열을 성공적으로 이어 썼습니다.");
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

}
