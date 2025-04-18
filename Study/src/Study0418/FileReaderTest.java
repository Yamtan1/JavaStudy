package Study0418;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	static FileReader fr;
	static BufferedReader br;
	public static void main(String[] args) {
		
		try {
			fr = new FileReader("C:/Temp/jv_test/test.txt");
			
			int data = 0;
			while((data = fr.read()) != -1) { //파일의 끝은 -1로 정해놓음
				System.out.println((char)data);
			}
			fr.close();
			
			fr = new FileReader("C:/Temp/jv_test/test.txt");
			br = new BufferedReader(fr);
			
			System.out.println("버퍼 사용하기");
			String s = null;
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
