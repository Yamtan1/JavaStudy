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


@WebServlet("/regi")
public class memberServlet extends HttpServlet {
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
		
		/* String grade2 = "";
        
        System.out.println("Received grade: " + grade); 
       
        if (grade != null) {
            if (grade.equals("A")) {
                grade2 = "VIP";
            } else if (grade.equals("B")) {
                grade2 = "일반";
            } else if (grade.equals("C")) {
                grade2 = "직원";
            }
        }
        
        System.out.println("Mapped grade2: " + grade2); */
		//grade 데이터타입이 CHAR(1)라서 변경이 안됨 다른 곳에서 손봐야할듯
			
		Member m = new Member();
		m.setCustno(custno);
		m.setCustname(custname);
		m.setPhone(phone);
		m.setAddress(address);
		m.setJoindate(joindate);
		m.setGrade(grade);
		m.setCity(city);
		try {
			dao.insert(m);
			List<Member> list = dao.select();
			request.setAttribute("memberList", list);
			request.getRequestDispatcher("memberList.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}


}
