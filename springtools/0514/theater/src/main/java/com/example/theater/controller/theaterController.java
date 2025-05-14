package com.example.theater.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.theater.DAO.IBoardDAO;
import com.example.theater.DAO.IEventDAO;
import com.example.theater.DAO.IMemberDAO;
import com.example.theater.DAO.IQnaDAO;
import com.example.theater.DAO.IReserveDAO;
import com.example.theater.DAO.IReviewDAO;
import com.example.theater.DTO.BoardDTO;
import com.example.theater.DTO.MemberDTO;
import com.example.theater.DTO.QnaDTO;
import com.example.theater.DTO.ReviewDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class theaterController {
	
	private IMemberDAO memberdao;
	private IBoardDAO boarddao;
	private IEventDAO eventdao;
	private IReserveDAO reservedao;
	private IQnaDAO qnadao;
	private IReviewDAO reviewdao;

	
	@Autowired
	public theaterController(IMemberDAO dao, IBoardDAO dao1, IEventDAO dao2, IReserveDAO dao3, IQnaDAO dao4,IReviewDAO dao5) {
		memberdao = dao;
		boarddao = dao1;
		eventdao = dao2;
		reservedao = dao3;
		qnadao = dao4;
		reviewdao = dao5;
	}
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root....");
		return "index";
	}
	@GetMapping("/signup")
	public String signup() {
		System.out.println("회원가입 창으로..");
		return "signup";
	}
	@GetMapping("/login")
	public String logon() {
		System.out.println("로그인 화면으로...");
		return "login";
	}
	
	@GetMapping("/idcheck")
	public @ResponseBody int idcheck(@RequestParam("id") String id) {
		int result = memberdao.selectId(id);
		return result;
	}
	@PostMapping("/signup")
	public String memberSignup(@RequestParam("id")String id,
							   @RequestParam("pw")String pw,
							   @RequestParam("name")String name,
							   @RequestParam("phone")String phone,
							   @RequestParam("grade")String grade) {
		System.out.println("회원가입 완료....");
		memberdao.insertMember(id,pw,name,phone,grade);
		return "index";
	}
	@PostMapping("/login")
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw, HttpSession session) {
		MemberDTO member = memberdao.loginmember(id,pw);
		if(member != null) {
			System.out.println("회원정보 일치 로그인 완료...");
			session.setAttribute("loginId", member.getId());
			session.setAttribute("grade", member.getGrade());
		}
		else {
			System.out.println("회원정보 불일치");
		}
		System.out.println("로그인 완료....");
		return "index";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // 세션 완전 제거
	    return "redirect:/"; // 로그인 페이지로 이동
	}
	@GetMapping("/notice")
	public String noticeList(@RequestParam(name = "page", defaultValue = "1") int page, Model model){
		System.out.println("공지시항 페이지 접속");
		int pageSize= 10;
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + 9;
		
		int listCnt = boarddao.getListCount();
		int totalPage = (int) Math.ceil((double) listCnt / pageSize);
		int startPage = (int) ((page - 1) / 10) * 10 + 1; 
		int endPage = Math.min(startPage + 9, totalPage);
		
		List<BoardDTO> list = boarddao.getNoticeList(startRow, endRow);
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("list", list);
		return "notice";
	}
	@GetMapping("/writeNotice")
	public String writenotice() {
		System.out.println("공지사항 작성 페이지 접속");
		return "writeNotice";
	}
	@PostMapping("/writeNotice")
	public String writeNotice(@RequestParam("title")String title,
							  @RequestParam("content")String content,
							  @RequestParam("write")String write) {
		boarddao.insertNotice(title, content, write);
		System.out.println("공지사항 작성 완료");
		return "redirect:/notice";
	}
	@GetMapping("/gradeCheck")
	public @ResponseBody boolean gradeCheck(@RequestParam("grade") String grade) {
		return "관리자".equals(grade);	
	}
	@GetMapping("/event")
	public String event() {
		System.out.println("이벤트 페이지 가즈아");
		return "event";
	}
	@GetMapping("/joinEvent")
	public @ResponseBody boolean joinEvent(HttpSession session) {
		String id = (String) session.getAttribute("loginId");
		if (id == null || id.isEmpty()) {
	        return false;  // 로그인하지 않은 경우
	    }
		int count = eventdao.idCount(id);
		if(count < 3) {
			eventdao.insert(id);
			return true;
		}
		else {
			return false;
		}
	}
	@GetMapping("/reserve") 
	public String reserve(@RequestParam("title") String title, Model model) {
	    model.addAttribute("title", title);
	    return "reserve"; 
	}
	@PostMapping("/reserve")
	public String reserve(@RequestParam("title")String title,
						  @RequestParam("choicedate")String  choicedate,
						  @RequestParam("seats")String[] seats, HttpSession session, Model model) {
		String id = (String) session.getAttribute("loginId");
		
		if (id == null) {
	        return "redirect:/login";
	    }
		int reservecount = reservedao.reserveCount(id);
		if (seats.length > 2) {
	        model.addAttribute("error", "최대 2개의 좌석만 선택할 수 있습니다.");
	        model.addAttribute("title", title);
	        return "reserve"; // 예매 페이지로 다시 이동
	    }
		if (reservecount + seats.length > 2) {
	        model.addAttribute("error", "1인당 최대 2매까지만 예매할 수 있습니다. 이미 " + reservecount + "매 예매했습니다.");
	        model.addAttribute("title", title);
	        return "reserve";
	    }
		for (int i = 0; i < seats.length; i++) {
	        reservedao.insert(id, title, choicedate, seats[i]);
	    }
			model.addAttribute("title", title);
			model.addAttribute("date", choicedate);
			model.addAttribute("seats", seats);
		return "confirmed";
	}
	@GetMapping("/qna")
	public String qnaList(@RequestParam( name="page", defaultValue = "1") int page, Model model) {
		int pageSize = 10;
		int startRow = (page - 1) * 10 + 1;
		int endRow = page * pageSize;
		
		List<QnaDTO> list = qnadao.getQnaList(startRow, endRow);
		int listCnt = qnadao.ListCount();
		int totalPage = (int) Math.ceil((double)listCnt / pageSize);
		int startPage = (int)((page - 1) / 10) * 10 + 1;
		int endPage = Math.min(startPage + 9, totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", page);	
		
		return "qna";
	}
	@GetMapping("/qnaGrade")
	public @ResponseBody boolean qnaGrade(@RequestParam("grade") String grade) {
		System.out.println(grade);
		return "회원".equals(grade);
	}
	@GetMapping("/writeQna")
	public String writeQna() {
		return "writeQna";	
	}
	@PostMapping("/writeQna")
	public String qnaWrite(@RequestParam ("id") String id,
						   @RequestParam ("qtitle") String qtitle,
						   @RequestParam ("qcontent") String qcontent) {
		qnadao.insertQna(id, qtitle, qcontent);
		return "redirect:/qna";
	}
	@RequestMapping("/qnaView")
	public String qnaView(@RequestParam("id") String id,
						  @RequestParam("qtitle") String qtitle,
						  @RequestParam("qcontent") String qcontent,
						  @RequestParam("qdate") String qdate, Model model, HttpSession session,
						  @RequestParam(name = "page", defaultValue = "1") int page) {
		String userid = (String) session.getAttribute("loginId");
		String grade = (String) session.getAttribute("grade");
		if(grade != null && userid.equals(id) || "관리자".equals(grade)) {
			 QnaDTO qna = qnadao.selectView(id, qtitle, qcontent, qdate);
		     model.addAttribute("qna", qna);
		     return "qnaView"; // 권한이 맞으면 qnaView 페이지 반환
		}
		else {
				model.addAttribute("error", "작성자 및 관리자만 조회할 수 있습니다.");
				int pageSize = 10;
		        int startRow = (page - 1) * 10 + 1;
		        int endRow = page * pageSize;

		        List<QnaDTO> list = qnadao.getQnaList(startRow, endRow);
		        int listCnt = qnadao.ListCount();
		        int totalPage = (int) Math.ceil((double) listCnt / pageSize);
		        int startPage = (int) ((page - 1) / 10) * 10 + 1;
		        int endPage = Math.min(startPage + 9, totalPage);

		        model.addAttribute("startPage", startPage);
		        model.addAttribute("endPage", endPage);
		        model.addAttribute("totalPage", totalPage);
		        model.addAttribute("list", list);
		        model.addAttribute("currentPage", page);

		        return "qna";
		}
	}
	@PostMapping("/qnaAnswer")
	public String qnaAnswer(@RequestParam("id") String id,
							@RequestParam("qtitle") String qtitle,
							@RequestParam("qcontent") String qcontent,
							@RequestParam("qdate") String qdate, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("qtitle", qtitle);
		model.addAttribute("qcontent", qcontent);
		model.addAttribute("qdate", qdate);
		return "qnaAnswer";
	}
	@PostMapping("/qnaAnswerUpdate")
	public String updateAnswer( @RequestParam("id") String id,
								@RequestParam("qtitle") String qtitle,
								@RequestParam("qcontent") String qcontent,
								@RequestParam("qdate") String qdate,
								@RequestParam("answer") String answer, RedirectAttributes redirectAttrs) {
		qnadao.updateAnswer(id,qtitle,qcontent,qdate,answer);
		redirectAttrs.addAttribute("id", id);
		redirectAttrs.addAttribute("qtitle", qtitle);
		redirectAttrs.addAttribute("qcontent", qcontent);
		redirectAttrs.addAttribute("qdate", qdate);
		redirectAttrs.addAttribute("answer", answer);
		return "redirect:/qnaView";
	}
	@GetMapping("/review")
	public String review(Model model) {
		List<ReviewDTO> list = reviewdao.selectReview();
		model.addAttribute("list", list);
		return "review";
	}
	@PostMapping("/writeReview")
	public String writeReview(@RequestParam("id") String id, @RequestParam("content") String content) {
		reviewdao.insert(id, content);
		return "redirect:/review";
	}
	@GetMapping("/reviewGrade")
	public @ResponseBody boolean reviewGrade(@RequestParam("grade") String grade) {
		if(grade != null && "회원".equals(grade) || "관리자".equalsIgnoreCase(grade)) {
			return true;
		}
		else {
			return false;
		}
	}
	@GetMapping("/tailerMade")
	public String tailerMade() {
		return "tailerMade";
	}
	@GetMapping("/remember")
	public String remember() {
		return "remember";
	}
}

