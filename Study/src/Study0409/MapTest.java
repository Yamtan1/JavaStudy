package Study0409;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//Map<Integer/*키*/, String/*값value*/> map = new HashMap<>(); //key = 번호  value=이름
		
		//map.put(1,"aaa");
		//map.put(2,"bbb");
		//map.put(3,"ccc");
		
		//String value = map.get(3);
		//System.out.println(value);
		
		Map<String, String> dictionary = new HashMap<>();
		
		while(true) {	
		System.out.println("1: 입력, 2: 조회, 0: 종료");
		int input = sc.nextInt();
		sc.nextLine();
		if(input==1) {
			System.out.println("입력할 단어 입력");
			String korean = sc.nextLine();
			System.out.println("입력할 단어의 영단어 입력");
			String english = sc.nextLine();
			dictionary.put(korean, english);
			System.out.println("입력되었습니다");
		} else if (input == 2) {
			System.out.print("조회할 단어(한글): ");
			String search = sc.nextLine();
			String result = dictionary.get(search);
			if (result != null) {
				System.out.println("영단어: " + result);
			} else {
				System.out.println("해당 단어는 사전에 존재하지 않습니다.");
			}
			}
			else if (input == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else {
				System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
		}
		}
		}
		
	}

