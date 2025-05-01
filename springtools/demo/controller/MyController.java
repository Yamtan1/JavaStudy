package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Vo.User;

@Controller //서블릿 기능을 하게 해줌
public class MyController {
	List<User> list = new ArrayList<>();
	
	@RequestMapping("/") //RequestMapping은 get이든 post든 다 받아줌
	public @ResponseBody String root() {
		System.out.println("root.................");
		return "Springboot Start!!!";  //리턴문의 용도는 첫번째는 페이지 이름이다(.jsp) 
	}								   //리턴의 두번째 용도는 데이터다(데이터를 보낼때는 @ResponseBody 함수 반환타입 앞에 적어야함)
	
	@GetMapping("/test") 
	public String test() {
		System.out.println("test...............");
		return "test";
	}
	
	/* @GetMapping("/test") //요청문과 페이지명이 일치할때는 void로 return문을 없애도 페이지가 불러와진다. 근데 그냥 써라
	public void test() {
		System.out.println("test...............");
		//return "test";
	}*/
	
	@GetMapping("/p1")
	public String p1(
			@RequestParam("name")String name, Model model) { //Model 뷰에다가 데이터를 전달할때 사용
		System.out.println("p1.........");
		model.addAttribute("name", name);
		model.addAttribute("age", 23);
		//request.setAttribute("name", name);
		return "p1";
	}
	
	/* @PostMapping("/p2") //☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★내가 한거☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
	public String p2(
			@RequestParam("id")String id, @RequestParam("pw")String pw, @RequestParam("name")String name, Model model) {
			System.out.println("p2.....");
			
		    User user = new User(id, pw, name);
		    list.add(user);

		    model.addAttribute("list", list);
		    return "p2"; 
		
	}*/
	@PostMapping("/p2")
	public String p2(User user, Model model) { //위 방법도 가능하지만 jsp의 name값과 Vo 혹은 DTO 클래스의 멤버변수 이름이 같을경우 매개변수에 클래스를 자료형(커맨드객체)으로 바로 넣어도 데이터가 삽입된다.
			System.out.println("p2.....");		//이럴경우 모델에 담지않아도 전달이 가능함. 대신 참조변수 이름은 클래스이름과 똑같이 하되 첫글자는 소문자로해야함(User user 처럼) p2.jsp 참고!
												//또한 이러한 커맨드 객채는 기본 생성자가 있어야한다.
		    list.add(user);

		    model.addAttribute("list", list);
		    return "p2"; 
	}
	
	@GetMapping("/p3/{id}/{pw}") //폼으로는 작동안됨!! 
	public String p3(@PathVariable("id")String id,
					 @PathVariable("pw")String pw, Model model) {	
		System.out.println("p3.................." + id + ", " + pw);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "p3";
	}
	
	
}
