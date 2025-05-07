package com.example.memberLogin0507.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.memberLogin0507.DAO.MemberDao;
@RestController //리턴을 데이터를 보내는 것으로 고정하는 컨트롤러임. 메소드 앞에@Responsebody를 쓸 필요가 없음.
public class MyRestController {
	
	MemberDao dao = new MemberDao();
	
	@GetMapping("/idcheck")
	public String idcheck(@RequestParam("id")String id) {
		System.out.println("idcheck......");
		boolean result = dao.selectId(id);
		if(result == true) {
			return "중복된 아이디 입니다";	
		}
		else {
			return "사용가능한 아이디 입니다";
		}
		
	}
	
}
