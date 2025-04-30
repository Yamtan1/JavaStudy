package tranferServlet;

import java.io.IOException;
import java.sql.SQLException;

import AccountService.Service;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/transfer")
public class transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service service  = new Service();
       

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fromAccountId = request.getParameter("fromAccount");
		String toAccountId = request.getParameter("toAccount");
		String amountStr = request.getParameter("amount");
		
		try {
			double amount = Double.parseDouble(amountStr);
			
			//트랜잭션 실행
			service.transfer(fromAccountId, toAccountId, amount);
			
			request.setAttribute("message", "이체성공" + fromAccountId + "에서" + toAccountId + "로 " + amount + "원 이체되었습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}catch (SQLException e) {
			request.setAttribute("errorMessage", "이체실패: " + e.getMessage());
		} catch(NumberFormatException e) {
			request.setAttribute("errorMessage", "유호하지 않은 금액입니다");
		}
		
	}

}
