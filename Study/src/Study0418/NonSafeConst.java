package Study0418;

interface Animal{
	int DOG = 1;
	int CAT = 2;
}
interface Person{
	int MAN =1;
	int WOMAN = 2;
}
public class NonSafeConst {

	public static void main(String[] args) {
		who(Person.MAN);
		//who(Animal.DOG);
	}

	public static void who(int man) {
		switch(man){
			case Person.MAN:
				System.out.println("남성손님입니다.");
				break;
			case Person.WOMAN:
				System.out.println("여성손님입니다.");
				break;
		}
	}
}
