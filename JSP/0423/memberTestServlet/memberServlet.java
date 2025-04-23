package memberControllre;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import memberDao.memberDao;
import memberVo.memberVo;

@WebServlet("/memberResult")
public class memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	memberDao dao = new memberDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String grade = "일반";
		memberVo member = new memberVo();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setGrade(grade);
		
		try {
			dao.insert(member);
			memberVo m = dao.select(member);
			if (m != null) {
                request.setAttribute("id", m.getId());
                request.setAttribute("pw", m.getPw());
                request.setAttribute("name", m.getName());
                request.setAttribute("grade", m.getGrade());
            } else {
                // 값이 null이라면 문제 처리 로직 추가
                request.setAttribute("error", "회원 정보를 찾을 수 없습니다.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "회원 정보를 조회하는데 오류가 발생했습니다.");
        }
		
		request.getRequestDispatcher("memberResult.jsp").forward(request, response);
	}

}
