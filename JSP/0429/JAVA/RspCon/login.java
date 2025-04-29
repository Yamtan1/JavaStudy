package RspCon;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import userDao.Crud;
import userVo.userInfo;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Crud dao = new Crud();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		userInfo user = new userInfo();
		
		user.setId(id);
		user.setPw(pw);
		userInfo user2 = dao.loginUser(user);
		if(user2 != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", user2.getId());	
			session.setAttribute("pw", user2.getPw());
			response.sendRedirect("Rsp.jsp");
		}
		else {
			response.sendRedirect("Rsp.jsp");
		}
			
	}

}
