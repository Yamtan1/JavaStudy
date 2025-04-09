package Study0409;

import java.util.ArrayList;
import java.util.List;

public class Mapper_Oracle extends Member implements IMapper_crud{

	
	Mapper_Oracle(){}
	public void create(Member m) {
		System.out.println("오라클 멤버 등록");
	}
	@Override
	public List<Member> readAll() {
		List<Member> List = new ArrayList<>();
		return List;
	}
	@Override
	public Member read(int i) {
		Member member = new Member();
		return member;
	}
}