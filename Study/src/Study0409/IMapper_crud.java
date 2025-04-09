package Study0409;

import java.util.List;

public interface IMapper_crud {

	public void create(Member m);
	public List<Member> readAll();
	public Member read(int i);

}
