package memberController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import memberDao.MemberDao;
import memberVo.Member;


@WebServlet("/insertMember")
public class insertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Member> list = new ArrayList<>();
	MemberDao dao = new MemberDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		dao.insert(member);
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}	

}
