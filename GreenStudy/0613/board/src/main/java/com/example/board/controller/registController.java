package com.example.board.controller;

import com.example.board.service.MemberService;
import com.example.board.dto.MemberDto;
import com.example.board.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/regist")
public class registController {

    @Autowired
    MemberService memberService;

    @GetMapping("/registForm")
    public String registForm(){
        return "regist/registForm";
    }
    @PostMapping("/regist")
    public String regist(MemberDto member){
        memberService.insertMember(member);
        return "/";
    }
}
