package Study0314;

import java.util.Scanner;

public class Array0314 {

	public static void main(String[] args) {
		// 4 4 배열 학생성적 관리 
		// 안에는 전부 점수 열 0 1 2 인덱스 는 각과목의 성적 열인덱스 마지막은 총점 행인덱스는 마지막은 국어 총점 영어 총점
		Scanner sc = new Scanner(System.in);
		
		int[][] point = new int[4][4];//16칸 배열 생성
		int sum = 0; // 포인트배열 0열의 총 합
		int sum1 = 0; // 포인트배열 1열의 총 합
		int sum2 = 0; // 포인트배열 2열의 총 합
		int sum3 = 0; // 포인트배열 0행의 총 합
		int sum4 = 0; // 포인트배열 1행의 총 합
		int sum5 = 0; // 포인트배열 2행의 총 합

		// 1. 총점 부분을 제외한 인덱스에 입력한 값을 지정하는 단계
		// 마지막 행, 열 인덱스 값이 채워지면 안되므로 length 값에 - 1을 해야함.
		for(int i = 0 ; i < point.length -1 ; i++) {
			for(int x = 0 ; x < point[i].length -1 ; x++) {
				if(point[i][x] == 0) {
					point[i][x] = sc.nextInt();
				}
				//System.out.print(point[i][x] + " ");
			}
			//System.out.println("\t");
		}
		// 없어도 되는 반복문임. 그냥 값이 제대로 들어갔는지 확인하기 위해 작성함.
		for(int i = 0 ; i < point.length -1 ; i++) {
			for(int x = 0 ; x < point[i].length -1 ; x++) {
			//System.out.print(point[i][x] + " ");
			}
			//System.out.println("\t");
		}

		//모든 배열의 행과 열을 훑어볼 필요 없음. 이미 필요한 값은 다 들어가 있고 열의 마지막 인덱스에(point[0][3],point[1][3],point[2][3])
		//총점이 들어가면됨.
		for(int i = 0 ; i < 1 ; i++) {
			for(int x = 0 ; x < point[i].length ; x++) {
				sum = sum + point[i][x]; //i가 0이고 x 는 1,2,3으로 증가할때마다 값을 sum에 저장
				sum1 = sum1 + point[i+1][x]; // 0행의 인덱스열을 구한것과 마찬가지로 1행의 인덱스 열의 총합도 구해야함
											 // i값이 증가하게 반복문을 설정하면 배열을 초과하기 때문에 에러가 남
				sum2 = sum2 + point[i+2][x]; // 그러므로 i값 뒤에 숫자를 직접 더 해 에러를 방지함.
				if(point[i][x] == 0) { //값을 더하다가 값이 비어있는(0인상태) 총점의 배열을 만난 경우 sum의 값을 해당 배열에 대입
					point[i][x] = sum;
				}
				if(point[i+1][x] == 0) { //1행 인덱스 열의 총합을 저장하고 위와 같은 방식으로 비어 있는 배열에 대입
					point[i+1][x] = sum1;
				}
				if(point[i+2][x] == 0) { //2행 인덱스 열의 총합을 저장하고 위와 같은 방식으로 비어 있는 배열에 대입
					point[i+2][x] = sum2;
				}
			}
		}
		// 위에선 행을 고정시켜 일정한 값을 더한 다음 해당 행에 있는 인덱스열을 다 더했다면
		// 이번엔 반대로 진행하여 열을 고정시키고 일정한 값을 더한 다음 해당 인덱스 행을 더 해 위와 같은 조건문으로 대입
		for(int a = 0 ; a < 1 ; a++){
			for(int b = 0 ;b < point.length ; b++){ //반복문 속 leghth는 바뀌는 값이 행인지 열인지에 따라 달라짐
				sum3 = sum3 + point[b][a];         //행이 달라지는 상태이므로 행의 length 값을 대입하였으며 열의 leghth 값을 대입
				sum4 = sum4 + point[b][a+1];		// 할 경우 현재는 [4][4]같은 크기로 문제가 없으나 [4][5]일 경우 인덱스가 초과하여 에러가 나타남.
				sum5 = sum5 + point[b][a+2];
				if(point[b][a] == 0){   //위에서 설명했으니 생략.
					point[b][a] = sum3;
				}
				if(point[b][a+1] == 0){
					point[b][a+1] = sum4;
				}
				if(point[b][a+2] == 0){
					point[b][a+2] = sum5;
				}
			}
		}
		//[4][4]를 직접넣을 수도 있으나 숫자가 커질 것을 가정하여 각 행 열의 length 값에서 -1 을 연산하여 인덱스의 최대 길이를 맞춤.
		point[point.length-1][point[0].length-1] = sum + sum1 + sum2;  //총점은 맨끝이나 맨밑에서 더해도 똑같음
		System.out.print("국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "총점" + "\t"); //이쁘게 출력하기1
		System.out.println();
		for(int i = 0 ; i < point.length  ; i++) {
			for(int x = 0 ; x < point[i].length  ; x++) {
				System.out.print(point[i][x] + "\t"); //이쁘게 출력하기2
			}
			System.out.println("\t");
		}
	}

}
