package RspCon;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import userDao.Crud;
import userVo.userInfo;


@WebServlet("/membership")
public class membership extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Crud dao = new Crud();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		userInfo user = new userInfo();
		
		user.setId(id);
		user.setPw(pw);
		dao.insertUser(user);
		
		response.sendRedirect("login.jsp");
		
	}

}
