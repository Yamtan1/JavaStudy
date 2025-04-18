package Study0418;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diary {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<File> list = new ArrayList<>();
		
		
		boolean flag = true;
		while(flag) {
		System.out.println("------------------메뉴를 선택하세요--------------------");
		System.out.println("1번 다이어리 생성, 2번 일기 쓰기, 3번 일기 조회, 0번 프로그램 종료");
		int input = sc.nextInt();
		sc.nextLine();
		if(input == 1) {
		//다이어리 생성
		System.out.println("생성할 일기장의 이름을 정해주세요");
		String name = sc.nextLine();
		File Diary = new File("C:/Temp/jv_test/" + name + ".txt");
		try {
			if(Diary.createNewFile()) {
				System.out.println("일기장이 생성되었습니다" + "/ 일기장 이름 : " + Diary.getName());
			}
			else {
				System.out.println("일기장이 이미 존재합니다");
			}
		} catch (IOException e) {
			System.out.println("파일 생성 중 문제가 발생했습니다");
			e.printStackTrace();
		} 
		
		}
		else if(input == 2) {
		//일기쓰기 
		System.out.println("작성할 일기장의 이름을 적어주세요");
		String name = sc.nextLine();
		System.out.println("일기를 작성해주세요");
		try {
			FileWriter dwrite = new FileWriter("C:/Temp/jv_test/" + name + ".txt", true);
			String write = sc.nextLine();
			dwrite.write( "\n" + write + "\n" );
			
			
			dwrite.close(); // 데이터베이스의 commit과 같은느낌 반드시 써야함
			
			System.out.println("일기장에 일기를 성공적으로 썼습니다.");
			
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		}
		else if(input == 3) {
		//일기 조회
		System.out.println("조회할 일기장의 파일 이름을 적어주세요");
		
		String name = sc.nextLine();
		System.out.println("일기를 전체 조회합니다.");
		try {
			FileReader dreader = new FileReader("C:/Temp/jv_test/" + name + ".txt");
			BufferedReader br = new BufferedReader(dreader);
			
			//System.out.println("버퍼 사용하기");
			String s = null;
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(input == 0) {
			System.out.println("일기장을 종료합니다");
			flag = false;
		}
		else {
			System.out.println("정확한 번호를 입력해주세요");
			continue;
		}
		}
	}

}
