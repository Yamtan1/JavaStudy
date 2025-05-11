package com.example.mybatis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mybatis.dao.IMemberDAO;
import com.example.mybatis.dto.MemberDTO;

@Controller
public class MemberController {
	
	private IMemberDAO memberDao;
	
	@Autowired
	public MemberController(IMemberDAO dao) {
		memberDao = dao;
	}
	
	@GetMapping("/")
	public String root() {
		System.out.println("root....");
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<MemberDTO> list = memberDao.getList();
		model.addAttribute("list", list);
		
		return "memberList";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") String id, Model model) {
		MemberDTO member = memberDao.getMember(id);
		//System.out.println("detail controller member: " + member);
		model.addAttribute("member", member);
		return "detail";
	}
	
	@PostMapping("/modify")
	public String modify(MemberDTO member) {
		System.out.println("modify param : " + member);
		memberDao.update(member);
		
		return "redirect:/list";
	}
	@GetMapping("/delete/{id}")
	public String delete (@PathVariable("id") String id) {
		memberDao.delete(id);
		
		return "redirect:/list";
	}
	
	@PostMapping("/insert")
	public String insert(MemberDTO member) {
		memberDao.insert(member);
		return "redirect:/list";
	}
}
