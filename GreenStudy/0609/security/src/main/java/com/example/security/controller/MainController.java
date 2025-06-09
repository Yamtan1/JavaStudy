package com.example.security.controller;

import com.example.security.dto.MemberDto;
import com.example.security.entity.MemberEntity;
import com.example.security.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/regist")
    public String showSignupForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "regist"; // JSP or Thymeleaf
    }

    @PostMapping("/registProc")
    public String processSignup(@ModelAttribute MemberDto dto) {
        MemberEntity member = new MemberEntity();
        member.setUsername(dto.getUsername());
        member.setPassword(passwordEncoder.encode(dto.getPassword()));
        member.setName(dto.getName());
        member.setRole(dto.getRole() != null ? dto.getRole() : "ROLE_MEMBER");

        memberRepository.save(member);

        System.out.println(">>> 저장 완료: " + member); // 🔍 로그 찍히는지 꼭 확인
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/success")
    public String loginSuccess() {
        return "success"; 
    }
}
