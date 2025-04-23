package memberControllre;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import memberDao.memberDao;
import memberVo.memberVo;


@WebServlet("/loginsuc")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	memberDao dao = new memberDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		memberVo m = new memberVo();
		m.setId(id);
		m.setPw(pw);
		memberVo m2;
		try {
			m2 = dao.loginselect(m);
			if(m2 != null) {
				HttpSession session = request.getSession();
				session.setAttribute("id", m2.getId());	
				session.setAttribute("pw", m2.getPw());
				session.setAttribute("name", m2.getName());
				session.setAttribute("grade", m2.getGrade());
				response.sendRedirect("loginsuc.jsp");
				//request.getRequestDispatcher("loginsuc.jsp").forward(request, response);
			}
			else {
				System.out.println("로그인 실패");
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {	
			e.printStackTrace();
		}
		
		
		
	}

}
