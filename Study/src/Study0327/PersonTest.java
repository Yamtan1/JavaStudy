package Study0327;

import vo.Person0327;

public class PersonTest {

	public static void main(String[] args) {
		
		 
		Person0327 h1 = new Person0327('m');	
		Person0327 h2 = new Person0327('f');
		Person0327 h3 = new Person0327('m');
		Person0327 h4 = new Person0327('f');
		Person0327 h5 = new Person0327('m');
		Person0327 h6 = new Person0327('f');
		Person0327 h7 = new Person0327('m');
		Person0327 h8 = new Person0327('f');
		Person0327 h9 = new Person0327('f');
		Person0327 h10 = new Person0327('f');
		Person0327 h11 = new Person0327('m');
		Person0327 h12 = new Person0327('m');
		System.out.println(h1.getId() + " " + Person0327.cnt);
		
		Person0327[] list = new Person0327[12];
		list[0] = h1;
		list[1] = h2;
		list[2] = h3;
		list[3] = h4;
		list[4] = h5;
		list[5] = h6;
		list[6] = h7;
		list[7] = h8;
		list[8] = h9;
		list[9] = h10;
		list[10] = h11;
		list[11] = h12;

		GenderCount.gendercnt(list);

		/* PersonTest pt = new PersonTest();// static이 없으면 인스턴스 생성 후 처리해야함
		pt.genderCount(list); */
		
		
		
		
		
		/*int mcount = 0;
		int fcount = 0;
		for(int i = 0 ; i < list.length ; i++) {
			
			if(list[i].getGender() == 'f') {
				fcount++;	
			}
			else {
				mcount++;
			}			
		}
		System.out.println("남자 수 : " + mcount + ", 여자 수 : " + fcount);
		//번호가 4번인 사람의 성별을 알아내시오
		for(int i = 0 ; i < list.length ; i++) {
			if(list[i].getId() == 4) {
				System.out.println(list[i].getGender());
				break;
			}
		} */
		
		
	}
	 /* void genderCount(Person0327[] x) {  //내일 할거 이 함수를 다른 클래스에 넣어서 메인서 작동하도록 만들거임!!!!!!!!!!!!!!!!!!!!!
		int mcount1 = 0;
		int fcount1 = 0;
		for(int i = 0 ; i < x.length ; i++) {
			if(x[i].getGender() == 'f') {
				fcount1++;
			}
			else {
				mcount1++;
			}
		}
		System.out.println("남자 : " + mcount1 + ", 여자 : " + fcount1);
	} */
}
