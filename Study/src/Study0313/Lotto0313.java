package Study0313;

import java.util.Random;

public class Lotto0313 {

	public static void main(String[] args) {
		// 로또 번호 추출기 1~45번까지에옹
		// 6개의 번호를 얻어내야함. 배열에다가
		// 중복된 값이 나오면 안됨.
		Random rd = new Random();
		boolean flag = true; // 상태변수(영문 의미인 깃발, 의 뜻처럼 현재 상태를 인식,
		  					 // 처리 흐름을 제어하기 위한 변수.
						     // Boolean 타입의 변수이기 때문에 토글(on/off) 의 역할에 사용하기도 함.

		int[] lotto = new int[6]; //숫자 6개를 담을 배열
		int idx = 0;

		int num = rd.nextInt(45) + 1; //랜덤숫자 1~45중 한개를 생성
			lotto[idx] = num; //0번 인덱스는 첫번째 숫자로 중복이 없으므로 바로 배열 인덱스에 대입
			idx++; // 숫자를 인덱스에 대입 후 값 1 증가.
						 //현재 lotto[0]의 값은 대입되어 있는 상태
		while(idx < 6) { //현재 idx는 1, 5개의 숫자가  더 들어가야하기 때문에 총 반복 5번 진행
			flag = true; //flag 변수를 통해 반복문 진입
			num = rd.nextInt(45) + 1; //랜덤 숫자 생성
			for(int i = 0 ; i < idx ;i++){ // 여기서 i변수는 로또 배열의 인덱스를 확인하기 위한 변수
				if(num == lotto[i]) {		// 현재 생성된 숫자가 앞선 인덱스 숫자와 같을 경우 반복문으로 인해 로또배열 인덱스 0~5까지 확인
											// 반복문을 통해 lotto[1][2][3][4][5] 비교를 하고 해당 조건이 발생할 경우 작동
					System.out.println("발견" + num); // 조건문에 걸리면 해당 메세지 출력
					flag = false; // flag 변수를 false로 바꿔 해당 반복문을 종료함. (off) 스위치 같은 역할
					break;
				} //break;를 통해 조건문을 빠져나옴
			} //break;에서 빠져나온 후 다시 while 반복문으로 되돌아감.
				if(flag) { //중복된 값이 없을 시 랜덤숫자를 배열에 대입하기 위한 조건문
							// 현재 if문은 for문 안에 있는 조건문이 아님
					lotto[idx++] = num; //현재 idx값에 랜덤숫자를 대입하고 ++가 후위에 있으므로 대입 후 1증가
										// ex) lotto[1] = num 대입 후 idx값이 2로 증가
			}
		}
		System.out.println("........완료........");
		for(int i = 0 ; i < lotto.length ; i++){
			System.out.print(lotto[i] + " ");
		}
	}
}
