package com.example.exam0516.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.exam0516.DAO.ExamDAO;
import com.example.exam0516.DAO.ExamResultDAO;
import com.example.exam0516.service.ExamService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ExamController {
	
	ExamDAO examdao;
	ExamResultDAO erdao;
	ExamService es = new ExamService();
	
	@Autowired
	public ExamController(ExamDAO dao, ExamResultDAO dao1) {
		examdao = dao;
		erdao = dao1;
	}	
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	@PostMapping("/exam")
	public String exam(@RequestParam("id") String id, @RequestParam("phone")String phone, HttpSession session, RedirectAttributes rttr) {
		
		if(id != null && phone != null && !id.isEmpty() && !phone.isEmpty()) {
			session.setAttribute("id", id);
			session.setAttribute("phone", phone);
			try {
	            examdao.insert(id, phone);
	        } catch (DuplicateKeyException e) {
	            // 이미 존재할 경우 insert 생략 or 로그
	        }
			return "redirect:/examPage";
		}
		else {
			rttr.addFlashAttribute("error", "아이디 전화번호 입력 후 이용해주세요");
			return "redirect:/";
		}
	}
	@GetMapping("/examPage")
	public String examPage(HttpSession session) {
		if(session.getAttribute("id") != null && session.getAttribute("phone") != null) {
			return "/examPage";	
		}
		else {
		return "index";
		}
	}
	@PostMapping("/doExam")
	public String doExam(@RequestParam(value="q1", required=false) String q1,
						 @RequestParam(value="q2", required=false) String q2,
						 @RequestParam(value="q3", required=false) String q3,
						 @RequestParam(value="q4", required=false) String q4,
						 @RequestParam(value="q5", required=false) String q5, HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		String phone = (String) session.getAttribute("phone");
		// 기본값 처리
	    if (q1 == null) q1 = "no_answer";
	    if (q2 == null) q2 = "no_answer";
	    if (q3 == null) q3 = "no_answer";
	    if (q4 == null) q4 = "no_answer";
	    if (q5 == null) q5 = "no_answer";
	    
		erdao.insert(id, phone, q1, q2, q3, q4, q5);
		int total = es.totalPoint(q1, q2, q3, q4, q5);
		model.addAttribute("total", total);
		model.addAttribute("q1", q1);
		model.addAttribute("q2", q2);
		model.addAttribute("q3", q3);
		model.addAttribute("q4", q4);
		model.addAttribute("q5", q5);
		
		return "success";		
	}
}
