package com.example.jwt0619.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
	Long expirationMs = 1000 * 10 * 1L;
	Long RefreshExpirationMs = 14L * 24 * 60 * 60 * 1000;
	
	private SecretKey secretKey;

	public JwtUtil(@Value("${spring.jwt.secret}")String secret) {
		this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
								Jwts.SIG.HS256.key().build().getAlgorithm());
	}
	public String getId(String token) {
		String id = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
					.getPayload().get("id", String.class);
		return id;
		
	}
	
	public String AccessTokenCreateJwt(String id) {
		String token = Jwts.builder()
						.claim("id", id)
						.issuedAt(new Date(System.currentTimeMillis()))
						.expiration(new Date(System.currentTimeMillis() + expirationMs))
						.signWith(secretKey)
						.compact();
		return token;
	}
	public String RefreshTokenCreateJwt(String id) {
		String token = Jwts.builder()
				.claim("id", id)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + RefreshExpirationMs))
				.signWith(secretKey)
				.compact();
		return token;
	}
	public boolean isTokenValid(String token) {
		
	    try {
	        Jwts.parser() // 또는 parserBuilder()
	            .verifyWith(secretKey)
	            .build()
	            .parseSignedClaims(token); // parseClaimsJws → parseSignedClaims
	        return true;
	    } catch (JwtException | IllegalArgumentException e) {
	        return false;
	    }
	}
	
}
