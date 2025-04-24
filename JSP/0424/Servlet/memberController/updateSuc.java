package memberController;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import memberDao.memberCrud;
import memberVo.Member;

@WebServlet("/update")
public class updateSuc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	memberCrud dao = new memberCrud();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String custno =request.getParameter("custno");
		String custname =request.getParameter("custname");
		String phone =request.getParameter("phone");
		String address =request.getParameter("address");
		String joindate =request.getParameter("joindate");
		String grade =request.getParameter("grade");
		String city =request.getParameter("city");
		
		Member updateMem = new Member();
		updateMem.setCustno(custno);
		updateMem.setCustname(custname);
		updateMem.setPhone(phone);
		updateMem.setAddress(address);
		updateMem.setJoindate(joindate);
		updateMem.setGrade(grade);
		updateMem.setCity(city);
		
		try {
			dao.update(updateMem);
			List<Member> list = dao.select();
			request.setAttribute("memberList", list);
			request.getRequestDispatcher("memberList.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
