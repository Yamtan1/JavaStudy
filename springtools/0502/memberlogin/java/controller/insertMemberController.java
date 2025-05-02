package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Dao.MemberDao;
import com.example.demo.Vo.Member;

import jakarta.servlet.http.HttpServlet;



@Controller
public class insertMemberController extends HttpServlet {
	
	@Autowired
	MemberDao dao;
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root.....");
		
		return "member";
	}
	
	@PostMapping("/success")
	public String success(@RequestParam("id")String id, @RequestParam("pw")String pw, @RequestParam("name")String name) {
		Member m = new Member();
		m.setId(id);
		m.setPw(pw);
		m.setName(name);
		dao.insert(m);
		return "success";
	}
	
}
