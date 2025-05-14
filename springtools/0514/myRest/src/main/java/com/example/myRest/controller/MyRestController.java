package com.example.myRest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myRest.DTO.UserDTO;

@RestController
@RequestMapping("/api")
public class MyRestController {

	@GetMapping("/")
	public String root() {
		return "API test";
	}
	@GetMapping("/user/{no}")
	public UserDTO user(@PathVariable ("no") int no) {
		List<UserDTO> list = new ArrayList<>();
		UserDTO user1 = new UserDTO();
		user1.setId("abc");
		user1.setName("홍길동");
		UserDTO user2 = new UserDTO();
		user2.setId("qwer");
		user2.setName("임꺽정");
		list.add(user1);
		list.add(user2);
		return list.get(no);
	}
}
