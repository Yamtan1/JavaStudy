package com.example.securityEx03.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.securityEx03.dto.UserDto;
import com.example.securityEx03.entity.User;
import com.example.securityEx03.service.UserService;

@Controller
public class JoinCotroller {
	
	@Autowired
	private UserService userService;
	
	public JoinCotroller(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "registForm";
	}
	@PostMapping("/registProc")
	public String regist(UserDto userdto){
		User result = userService.regist(userdto);
		if(result != null) {
			return "redirect:/login";
		}
		return "redirect:/regist";
	}

}
