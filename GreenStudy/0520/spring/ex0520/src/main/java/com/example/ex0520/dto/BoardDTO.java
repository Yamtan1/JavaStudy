package com.example.ex0520.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BoardDTO {
	
	@NotNull (message ="제목은 필수 입력 값입니다.")
	private String title;
	private String content;
	@NotNull (message ="작성자는 필수 입력값입니다.")
	private String writer;
	private String regdate;

}
