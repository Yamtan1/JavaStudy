package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.MemberDao2;
import com.example.demo.dto.MemberDTO;

@Controller
public class MemberController {
	@Autowired //자동으로 연결해달라는 뜻 new MemberDao(); 안써도 작동가능, MemberDao 클래스에 있는 @Repository를 통해 연결됨. 
			   //기본적으로 있는 Model, Request 등은 @Repository하지 않아도 @Autowired만으로 연결가능하나 사용자가 직접 만들 자료형은 @Autowired를 사용해야함 
	private MemberDao2 dao;
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root...........");
		
		return "index";
	}
	
	@GetMapping("/testList")
	public String test(@RequestParam("id")String id,Model model) {
		System.out.println("testList......");
		System.out.println(id);
		MemberDTO member = dao.viewMember(id);
		model.addAttribute("member", member);
		return "testList";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list....");
		List<MemberDTO> list = dao.list();
		model.addAttribute("list", list);
		
		return "list";
	}
}
