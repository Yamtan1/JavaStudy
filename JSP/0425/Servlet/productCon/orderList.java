package productCon;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import productDao.productDao;
import productVo.orderListVo;


@WebServlet("/order")
public class orderList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	productDao dao = new productDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<orderListVo> list = dao.select();
			request.setAttribute("orderL", list);
			request.getRequestDispatcher("orderList.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
