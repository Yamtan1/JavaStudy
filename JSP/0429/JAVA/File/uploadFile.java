package File;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 1, // 1메가 이하면 디스크에 저장
	maxFileSize = 1024 * 1024 * 10,		// 최대 10메가 파일 업로드 허용
	maxRequestSize = 1024 * 1024 * 15,	// 요청 전체 크기 15메가 제한
	location = "C:/temp"
	)
@WebServlet("/uploadProc")
public class uploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 upload폴더 지정
		String uploadPath = request.getServletContext().getRealPath("/img/");
		System.out.println("uploadPath : " + uploadPath);
		
		//2 일반 파라미터 처리
		String desc = request.getParameter("desc");
		System.out.println("desc : " + desc);
		
		//3 파일 처리
		Part part = request.getPart("imgfile");
		long size = part.getSize();
		if(size > 0) {
			part.write(uploadPath + part.getSubmittedFileName());
			part.delete();
			request.setAttribute("filename", part.getSubmittedFileName());
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("fail.jsp");
		}
	}

}
