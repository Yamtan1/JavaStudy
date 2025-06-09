package com.example.securityEx03.contorller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.securityEx03.auth.CustomUserDetails;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	@PreAuthorize("hasAnyRole('MEMBER', 'ADMIN')")
	@GetMapping("/mypage")
	public String mypage(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
		
		model.addAttribute("user",customUserDetails);
		return "/members/mypage";
	}
	
	

}
