package com.example.board.controller;

import com.example.board.service.MemberService;
import com.example.board.dto.MemberDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String root(){
        return "login";
    }
    @PostMapping("/login")
    public String login(MemberDto member, RedirectAttributes rttr, HttpSession session){
        boolean result = memberService.loginUser(member);
        if(result == true){
            session.setAttribute("loginId", member.getId());
            return "redirect:/board/boardPage";
        }
        else{
            rttr.addFlashAttribute("msg", "로그인 정보가 일치하지 않습니다.");
            return "redirect:/";
        }

    }
}
