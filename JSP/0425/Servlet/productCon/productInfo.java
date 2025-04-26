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
import productVo.product;


@WebServlet("/productInfo")
public class productInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	productDao dao = new productDao();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<product> list = dao.productInfo();
			request.setAttribute("product", list);
			request.getRequestDispatcher("productInfo.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
