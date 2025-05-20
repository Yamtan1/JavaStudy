package com.example.sessionEx.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
	@NotNull(message = "아이디는 필수 입력값입니다.")
	private String id;
	@NotNull(message = "pw is null")
	@Size(min=3, max=10, message = "pw min 3, max 10")
	private String pw;
	private String name;
	private String role;
	
	/*
	@NonEmpty: null 또는 empty 불가 (문자열, 컬렉션, 맵, 배열)

	@NotBlank: null, empty, 공백 문자 불가 (문자열 전용)
	
	@Size(min=, max=): 문자열/컬렉션의 크기 제한
	
	@Min(value), @Max(value): 숫자 최소/최대 값
	
	@Email: 이메일 형식
	
	@Pattern(regexp=): 정규식 패턴
	
	@Positive, @PositiveOrZero: 양수 또는 0 이상
	
	@Negative, @NegativeOrZero: 음수 또는 0 이하
	
	@Future, @FutureOrPresent: 미래 날짜
	
	@Past, @PastOrPresent: 과거 날짜

	*/
}
