package memberController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePage")
public class updatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String custno =request.getParameter("custno");
		String custname =request.getParameter("custname");
		String phone =request.getParameter("phone");
		String address =request.getParameter("address");
		String joindate =request.getParameter("joindate");
		String grade =request.getParameter("grade");
		String city =request.getParameter("city");
		
		request.setAttribute("custno", custno);
		request.setAttribute("custname", custname);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("joindate", joindate);
		request.setAttribute("grade", grade);
		request.setAttribute("city", city);
		
		request.getRequestDispatcher("memberUpdate.jsp").forward(request, response);
		
		
	}

}
