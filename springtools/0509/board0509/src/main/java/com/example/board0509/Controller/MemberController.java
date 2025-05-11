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
	public String boardList(Model model) {
		List<BoardDTO> list = boarddao.getList();
		model.addAttribute("blist", list);
		return "boardList";
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
	
}
