package Study0404;

public class StringTest {

	public static void main(String[] args) {
		//문자열 비교 !!!!! 중요!!!!!!!!!!!! 
		
		String s1 = "Hello";
		String s2 = "Hello"; 
		
		System.out.println(s1 == s2); //주소값이 같음 Hello를 두번썻지만 저장되어 있는 주소는 한 곳임.
									  // String 타입 문자열은 한번 할당되면 고정 불변이다.
		// s1 = "Hello2"; // 이러면 주소가 바뀌는거임 Hello는 원래 주소에 있음.
		String s3 = new String("Hello");
		System.out.println(s1 == s3);
		
		System.out.println(s1.equals(s3)); // 주소값이 아닌 가지고 있는 값(내용)이 같은지 비교하는 코드
		
		char x =s1.charAt(4); //s1의 n(매개변수)번째 문자를 출력해주는 함수
		System.out.println(x);
		
		char[] y = new char[s1.length()]; //문자열은 길이를 알아낼때 함수를 이용함 lenght() 
		
		for(int i = 0; i < y.length; i++) {
			y[i] = s1.charAt(i);
			System.out.print(y[i]);
		}
		System.out.println();
		System.out.println(s1.length());
		//-------------------------------------------------------------------------------
		//substring()
		System.out.println(s1.substring(2)); // 지정한 인덱스부터 뒤로 다 출력
		System.out.println(s1.subSequence(1, 4)); // 지정한 인덱스부터 엔드 인덱스 전 까지!! 출력은 함. 엔드 인덱스 글자는 포함 하지 않음
		
		//contains()
		boolean tf = s1.contains("Hel"); //s1의 문자열이 해당매개변수의 값을 가지고 있는지 확인하는 함수. 연속되어야 함.
		System.out.println(tf);
		
		//indexOf()
		int z = s1.indexOf("ello"); // 매개변수의 문자열이 몇번째 인덱스에서 시작되는지 확인하는 함수
		System.out.println(z);
		
		//equals()
		String str1 = "    Java      "; //대문자
		String str2 = "java"; //소문자		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2)); // 같은지 비교하는데 대소문자는 구분하지 않고 내용이 같은지 확인하는 함수
		
		System.out.println(str1.toUpperCase()); // 모든 문자를 대문자로 변경 및 반환해주는 함수. 단 원본이 바뀌지는 않음 str1의 값은 그대로 "Java"임.
		System.out.println(str1.toLowerCase()); // 소문자로 변경 및 반환
		
		//trim()
		String newstr = str1.trim(); // 앞뒤 공백제거해주는 함수
		System.out.println(newstr);
		System.out.println(newstr.length());
		
		//replace
		String a = str2.replace('a', 'o'); // 처음 매개변수 문자를 두번째 매개변수 문자로 바꿔주는 함수
		System.out.println(a);
		a = str2.replace("ja", "go");
		System.out.println(a);
		
		//split()
		String k ="aaa.bbb.ccc.ddd";
		String[] arr = k.split("//."); // 매개변수를 기준점으로 인덱스에 값을 대입함. 마침표는 안되는걸로 일단 기억하는걸로
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
