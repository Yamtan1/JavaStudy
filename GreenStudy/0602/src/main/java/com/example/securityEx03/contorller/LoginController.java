package com.example.securityEx03.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	@GetMapping("/login")
	public String login(@RequestParam(value="needLogin", required=false) String needLogin, Model model) {
		
		if(needLogin != null) {
			model.addAttribute("msg", "admin, member 전용페이지입니다");
		}
		return "login";
	}
	
	

}
