package com.example.board0509.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.board0509.dao.IBoardDAO;
import com.example.board0509.dao.IMemberDAO;
import com.example.board0509.dto.BoardDTO;
import com.example.board0509.dto.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	private IMemberDAO memberdao;
	private IBoardDAO boarddao;
	
	 @Autowired
	 public MemberController(IMemberDAO memberdao, IBoardDAO boarddao) {
	        this.memberdao = memberdao;
	        this.boarddao = boarddao;
	    }
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root---------------");
		return "index";
	}
	
	
	@GetMapping("/signup")
	public String signup() {
		System.out.println("회원가입창으로...");
		return "signup";
	}
	
	@PostMapping("/signin")
	public String signin(MemberDTO member) {
		memberdao.memberInsert(member);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("id")String id, @RequestParam("pw") String pw, Model model, HttpSession session) {
		int result = memberdao.login(id, pw);
		if(result == 1) {
			session.setAttribute("loginId", id); // 세션에 로그인 ID 저장
			return "redirect:/boardList";
		}
		else {
			model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
	        return "index";
		}
	}
	@GetMapping("/boardList")
	public String boardList(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
	    int pageSize = 10; //한 페이지에 표시할 페이지 개수
	    int startRow = (page - 1) * pageSize + 1; //시작 row
	    int endRow = page * pageSize; // 끝 row

	    int totalCount = boarddao.getTotalCount(); //총 게시글 수 가져오기
	    
	    // 총 페이지 수 계산 math.ceil을 올림함수로 소수점이있다면 다음 정수로 올림. 예) 2.1 ->3 / 3.5 -> 4 / 7.0 -> 7
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize);
	    
	    int startPage = (int) ((page - 1) / 10) * 10 + 1;  // 페이지 번호의 시작 int형으로 0.2,0.3의값이아니라 0으로 계산됨 
	    													// 페이지가 5일 경우 1, 15일 경우 1, 25일 경우 2로 계산됨
	    													// 5페이지 일 경우(page - 1) / 10 = (5 - 1) / 10 = 0, 0 * 10 + 1 = 1
	    
	    int endPage = Math.min(startPage + 9, totalPages);  // 페이지 번호의 끝
	    /* startPage + 9는 보여줄 최대 페이지 수 (예: 10)
			totalPages는 전체 페이지 수 (예: 6)
			Math.min()은 둘 중 더 작은 값을 고름			
			startPage + 9이 더 크면 → totalPages가 사용됨			
			totalPages가 더 크면 → startPage + 9 사용됨 */ 
	    List<BoardDTO> blist = boarddao.getPageList(startRow, endRow);
	    
	    model.addAttribute("blist", blist); //게시판 목록이 담겨있는 리스트
	    model.addAttribute("currentPage", page); // 현재페이지를 뜻함 기본값은 1이지만 내가 게시판 페이지 번호를 누르면 해당 값으로 바뀜
	    model.addAttribute("startPage", startPage); 
	    model.addAttribute("endPage", endPage);
	    model.addAttribute("totalPages", totalPages);
	    
	    return "boardList";  // JSP 페이지 이름
	}

	
	@GetMapping("/write")
	public String writePage() {
	    return "write"; 
	}
	@PostMapping("/write")
	public String write(BoardDTO board, HttpSession session) {
	    String loginId = (String) session.getAttribute("loginId");
	    board.setWrite(loginId); // 작성자 자동으로 세팅

	    boarddao.boardInsert(board); // DAO 통해 insert 실행
	    return "redirect:/boardList";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // 세션 완전 제거
	    return "redirect:/"; // 로그인 페이지로 이동
	}
	
}
