package test;

import Study0428.Dao.MemberDao;
import Study0428.Dto.MemberDto;

public class DaoTest {

	public static void main(String[] args) {
		
		MemberDao dao = MemberDao.getInstance();
		
		
		for (MemberDto m : dao.selectAll()) {
			System.out.println(m);
		}

	}

}
