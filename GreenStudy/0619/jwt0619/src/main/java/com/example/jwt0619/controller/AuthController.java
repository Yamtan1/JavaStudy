package com.example.jwt0619.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt0619.util.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> request, HttpServletResponse response){
		String id = request.get("id");
	    String pw = request.get("pw");
		
	    if("user".equals(id) && "1234".equals(pw)) {
	    	
	    	String accessToken = jwtUtil.AccessTokenCreateJwt(id);
	    	String refreshToken = jwtUtil.RefreshTokenCreateJwt(id);
	    	
	    	response.setHeader("Authorization", "Bearer " + accessToken);
	    	ResponseCookie cookie = ResponseCookie.from("refreshToken", refreshToken)
	                .httpOnly(true)
	                .path("/")
	                .maxAge(14 * 24 * 60 * 60)
	                .build();
	        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
	        
	    	return ResponseEntity.ok("Login Success");
	    }
	    
		return ResponseEntity.status(401).body("Login Fail");
	}
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response){
		String refreshToken = null;
		Cookie[] cookies = request.getCookies();
		
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if ("refreshToken".equals(cookie.getName())) {  // ✅ 조건문 추가!
	                refreshToken = cookie.getValue();
	                break;
	            }
	        }
	    }
		if (refreshToken == null || !jwtUtil.isTokenValid(refreshToken)) {
			return ResponseEntity.status(401).body("Invalid or missing refresh token");
		    }
		
		String id = jwtUtil.getId(refreshToken);
		String newAccessToken = jwtUtil.AccessTokenCreateJwt(id);
		response.setHeader("Authorization", "Bearer " + newAccessToken);
		return ResponseEntity.ok("Access token reissued");
	}

}
