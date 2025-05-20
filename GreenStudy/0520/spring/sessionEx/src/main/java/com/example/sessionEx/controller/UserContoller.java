package com.example.sessionEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sessionEx.dao.IUserDAO;
import com.example.sessionEx.dto.UserDTO;

import jakarta.validation.Valid;

@Controller
//http://localhost:8080/user
@RequestMapping("/user")
public class UserContoller {
	
	@Autowired
	private IUserDAO userdao;
	
	//http://localhost:8080/user/userlist
	@GetMapping("/userlist")
	public String userlist(Model model) {
		List<UserDTO> list = userdao.getUserList();
		model.addAttribute("list", list);
		
		return "/user/userlist";  //절대경로 user폴더안에 userlist페이지를 연결하라는 뜻
	}
	@GetMapping("/finduser")
	public String finduser() {
		return "/user/finduser";
	}
	@PostMapping("/finduser")
	public String finduser2(Model model, @RequestParam("name") String name, @RequestParam("role") String role) {
		UserDTO user = new UserDTO();
		user.setName(name);
		user.setRole(role);
		//List<UserDTO> user2 = userdao.getUserListWithParam(user);
		List<UserDTO> user2 = userdao.getUserListWithParam2(user);
		model.addAttribute("user2", user2);
		return "/user/userlist";
	}
	@PostMapping("/create")
	public String insert(@Valid UserDTO user, BindingResult result) {
		if(result.hasErrors()) {
			if(result.getFieldError("id") != null) {
				System.out.println("1: " 
					+ result.getFieldError("id").getDefaultMessage());
			}
			if(result.getFieldError("pw") != null) {
				System.out.println("2: " 
					+ result.getFieldError("pw").getDefaultMessage());
			}
		}
		userdao.insert(user);
		return "/user/regSuccess";
	}
	@GetMapping("/createUser")
	public String createUser() {
		return "/user/createUser";
	}
	@GetMapping("/regSuccess")
	public String regSuccess() {
		return "/user/regSuccess";
	}
	
}
