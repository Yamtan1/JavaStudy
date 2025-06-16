package com.example.jwtEx01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtEx01.dto.LoginDto;
import com.example.jwtEx01.utils.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class JwtTestController {
	
	@Value("${spring.jwt.secret}")
	private String secretKey;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
		//로그인 성공(성공했다고 가정함 실제로는 로직 필요)
		if("user01".equals(loginDto.getUsername()) && "1234".equals(loginDto.getPassword())) {
			//토큰 준비
			String token = makeJwt(loginDto.getUsername());
			
			//토큰 발행
			response.setHeader("userAuth", token);
			return "good";
		}
		return "bad";
	}
	@GetMapping("/user")
	public String getUserInfo(HttpServletRequest request) {
		String userAuth = request.getHeader("userAuth");
		
		if(userAuth == null || userAuth.isEmpty()) {
			return "bad";
		}
		String jwt = userAuth.split(" ")[1];
		String userInfo = jwtUtil.getUsername(jwt);
		
		return userInfo;
	}

	private String makeJwt(String username) {
		String jwt = jwtUtil.createJwt(username);
		String token = "Bearer " + jwt;
		return token;
	}

}
