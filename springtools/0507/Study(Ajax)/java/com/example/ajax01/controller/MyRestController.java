package com.example.ajax01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.ajax01.DTO.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController //리턴을 데이터를 보내는 것으로 고정하는 컨트롤러임. 메소드 앞에@Responsebody를 쓸 필요가 없음.
public class MyRestController {
	
	@GetMapping("/req1")
	public String req1() {
		System.out.println("req1..........");
		return "Hello Ajax....req1";
	}
	
	@GetMapping("/req2_1")
	public String req2_1() {
		System.out.println("req2.........");
		//이름 : David, 나이 : 28
		
		return "{\"name\":\"David\", \"age\": 28}"; // \는 문자열 안에 따옴표를 쓰겠다는 표시
	}
	
	@GetMapping("/req2_2")
	public String req2_2() throws JsonProcessingException {
		System.out.println("req2_2...........");
		
		User user = new User();
		user.setName("James Dean");
		user.setAge(24);
		
		//Jackson 라이브러리를 활용한 JSON데이터 만들기
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(user);
		return jsonStr;
	}
	
	@GetMapping("/req3")
	public String req3(@RequestParam("param")String param) {
		System.out.println("req3......" + param);
		
		return "ok. good";
	}
				//req4/Jane/33
	@GetMapping("/req4/{name}/{age}")
	public String req4(@PathVariable("name")String name, @PathVariable("age") int age) {
		System.out.println("req4.................." + name + ", " + age);
		return "Good";
	}
	
	@GetMapping("/req5")
	public String req5(User user) {
		System.out.println("req5............" + user);
		return "Good!!!";
	}
	
	@PostMapping("/req6")
	public String req6(@RequestParam("name")String name,
					   @RequestParam("age")int age) {
		System.out.println("req6......"  + name + ", " + age);
		
		return "req6. good";
	}
	@PostMapping("/req7")
	public String req7(User user) {
		System.out.println("req7........." + user);
		return "req7, good";
	}
	
	@PostMapping("/req8")
	public String req8(@RequestBody User user) {
		System.out.println("req8........." + user);
		
		return "req8, good!!";
	}
}
