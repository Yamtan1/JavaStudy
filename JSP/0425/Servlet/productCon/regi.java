package productCon;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import productDao.productDao;
import productVo.orderVo;


@WebServlet("/regi")
public class regi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	productDao dao = new productDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderno= request.getParameter("orderno");
		String shopno = request.getParameter("shopno");
		String orderdate = request.getParameter("orderdate");
		String pcode = request.getParameter("pcode");
		String amount = request.getParameter("amount");
		
		orderVo order = new orderVo();
		order.setOrderno(orderno);
		order.setShopno(shopno);
		order.setOrderdate(orderdate);
		order.setPcode(pcode);
		order.setAmount(amount);
		try {
			dao.insert(order);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
