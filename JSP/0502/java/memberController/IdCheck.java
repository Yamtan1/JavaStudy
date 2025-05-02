package memberController;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import memberDao.MemberDao;


@WebServlet("/idcheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		MemberDao dao = new MemberDao();
		boolean result = dao.selectId(id);
		
		request.setAttribute("result", result);
        
        // JSP 페이지로 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("member.jsp");
        dispatcher.forward(request, response);
	}


}
