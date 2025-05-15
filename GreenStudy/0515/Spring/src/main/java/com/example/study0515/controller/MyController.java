package com.example.study0515.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";			
	}
	@GetMapping("/loginForm")
	public String login(HttpSession session) {
		String id= (String) session.getAttribute("id");
		String pw= (String) session.getAttribute("pw");
		if(id != null && pw != null) {
			return "redirect:/";	
		}
		else {
			return "loginForm";
		}
		
	}
	@PostMapping("login")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session) {
		if("qwer".equals(id) && "1234".equals(pw)) {	
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			return "redirect:/sessionTest";
		}
		else {
			return "redirect:/loginForm";
		}
	}
	@GetMapping("/sessionTest")
	public String sessiontTest(HttpSession session, RedirectAttributes rttr) {
		String id= (String) session.getAttribute("id");
		String pw= (String) session.getAttribute("pw");
		if(id != null && pw != null) {
			return "/sessionTest";	
		}
		else {
			rttr.addFlashAttribute("error", "로그인 후 이용해주세용!!!!");
			return "redirect:/loginForm"; //새로운 요청(redirect)이라 model을 이용해서 데이터를 넣어도 전달이 안됨
										// 하지만 RedirectAttributes rttr를 활용하면 1회성으로 데이터를 담아 보낼 수 있음(휘발성)
										//redirect가 붙이면 뷰(jsp)로 가는게 아니라 컨트롤러의 요청경로로 가는거임
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/loginForm?logout=true";
	}
	@PostMapping("/extend-session")
	public void extendSession(HttpSession session) {
		session.setMaxInactiveInterval(60); // 60초 연장
	}
	
}


