package com.example.memberLogin0507.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.memberLogin0507.DAO.MemberDao;
import com.example.memberLogin0507.DTO.Member;




@Controller //1. return 활용(1) : view를 지정한다. 
			//2. return 활용(2) : 데이터를 전송한다. -> @ResponseBody를 사용해야한다.

public class MyController {
	@Autowired
	MemberDao dao;
	
	@RequestMapping("/") 
	public String root() {
		System.out.println("root...........");
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
