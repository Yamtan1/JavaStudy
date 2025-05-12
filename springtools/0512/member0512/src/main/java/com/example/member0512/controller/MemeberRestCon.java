package com.example.member0512.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.member0512.DTO.MemberDTO;
@CrossOrigin(origins = "*")
@RestController
public class MemeberRestCon {

	@GetMapping("/member")
	public MemberDTO member() {
		MemberDTO member = new MemberDTO();
		member.setId("aaa123");
		member.setPw("bbb123");
		member.setName("홍길동");
		member.setPhone("010-1111-2222");
		return member;
	}
		
	@GetMapping("/members")
	public List<MemberDTO> members() {
		List<MemberDTO> list = new ArrayList<>(); 
		MemberDTO member = new MemberDTO();
		member.setId("aa123");
		member.setPw("bb123");
		member.setName("홍길순");
		member.setPhone("010-1111-1111");
		MemberDTO member2 = new MemberDTO();
		member2.setId("gfgfg");
		member2.setPw("bqwewqe");
		member2.setName("임꺽정");
		member2.setPhone("010-2222-2222");
		
		list.add(member);
		list.add(member2);
		return list;	
	}
	@PostMapping("/member")
	public int addMember(MemberDTO member) {
		System.out.println(member);
		if(member != null) {
			return 1;
		}
		return 0;	
	}
	@PostMapping("/member2")
	public int addMember2(@RequestBody MemberDTO member) {
		System.out.println(member);
		if(member != null) {
			return 1;
		}
		return 0;	
	}

}
