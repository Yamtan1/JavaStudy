package ex03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/calResult")
public class calServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int n1 = Integer.parseInt(num1); 
		int n2 = Integer.parseInt(num2);
		
		int sum = n1 + n2;
		int sub = n1 - n2;
		int mul = n1 * n2;
		int div = n1 / n2;
		
		request.setAttribute("sum", sum);
		request.setAttribute("sub", sub);
		request.setAttribute("mul", mul);
		request.setAttribute("div", div);
		
		request.getRequestDispatcher("calResult.jsp").forward(request, response);
		
	}

}
