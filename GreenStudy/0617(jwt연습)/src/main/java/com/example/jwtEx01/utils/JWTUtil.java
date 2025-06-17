package com.example.jwtEx01.utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JWTUtil {
	
	private SecretKey secretKey;
	
	public JWTUtil(@Value("${spring.jwt.secret}")String secret) {
		this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
											Jwts.SIG.HS256.key().build().getAlgorithm());
		System.out.println("secretKey : " + secretKey.toString() + ", algorithm : " + secretKey.getAlgorithm());
	}
	//토큰에서 사용자 정보 추출
	public String getUsername(String token) {
		String username = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
						  .getPayload().get("username", String.class);
		return username;
	}
	
	public String getEmail(String token) {
		String email = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
						  .getPayload().get("email", String.class);
		return email;
	}

	//로그인 성공시 토큰 생성 : 시간 계산 - 1000 * 60 * 3L(long 타입이니까)
	public String createJwt(String username, String email, Long expirationMs) {
	   String token = Jwts.builder()
			   			  .claim("username", username)
			   			  .claim("email", email)
			   			  .issuedAt(new Date(System.currentTimeMillis()))
			   			  .expiration(new Date(System.currentTimeMillis()+ 1000 * 10 * expirationMs))
			   			  .signWith(secretKey)
			   			  .compact();
	   return token;
   }

}
