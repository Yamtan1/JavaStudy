package com.example.jwtEx01.controller;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtEx01.dto.LoginDto;
import com.example.jwtEx01.utils.JWTUtil;

import ch.qos.logback.core.status.Status;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class JwtTestController {
	
	@Value("${spring.jwt.secret}")
	private String secretKey;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
		//로그인 성공(성공했다고 가정함 실제로는 로직 필요)
		if("user01".equals(loginDto.getUsername()) && "1234".equals(loginDto.getPassword())) {
			//토큰 준비
			String token = makeJwt(loginDto.getUsername(), loginDto.getEmail());
			
			//토큰 발행
			response.setHeader("userAuth", token);
			return ResponseEntity.ok("로그인 성공");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패: 아이디 또는 비밀번호가 일치하지 않습니다.");
	}
	@GetMapping("/user")
	public ResponseEntity<?> getUserInfo(HttpServletRequest request) {
	    String userAuth = request.getHeader("userAuth");

	    if (userAuth == null || userAuth.isEmpty()) {
	        return ResponseEntity.status(401).body("토큰 없음");
	    }

	    try {
	        String jwt = userAuth.split(" ")[1];
	        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
	        JwtParser parser = Jwts.parser().verifyWith(key).build();
	        Jws<Claims> jws = parser.parseSignedClaims(jwt);

	        Claims claims = jws.getPayload();
	        String username = claims.get("username", String.class);
	        String email = claims.get("email", String.class);

	        Date iat = claims.getIssuedAt();
	        Date exp = claims.getExpiration();

	        System.out.println("발급(iat) : " + iat);
	        System.out.println("만료(exp) : " + exp);

	        return ResponseEntity.ok(username + ", " + email);

	    } catch (io.jsonwebtoken.ExpiredJwtException e) {
	        return ResponseEntity.status(401).body("토큰이 만료되었습니다. 다시 로그인해주세요.");
	    } catch (Exception e) {
	        return ResponseEntity.status(401).body("잘못된 토큰입니다.");
	    }
	}

	private String makeJwt(String username, String email) {
		String jwt = jwtUtil.createJwt(username, email, 1L);
		String token = "Bearer " + jwt;
		return token;
	}

}
