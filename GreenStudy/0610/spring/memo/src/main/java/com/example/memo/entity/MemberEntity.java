package com.example.memo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "tset_member")
public class MemberEntity extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, nullable=false, unique = true)
	@Size(min =3, max=50)
	private String username;
	@Column(length = 20)
	@Size(min = 4, max=20)
	private String pw;
	private String name;
	@Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "전화번호는 010으로 시작하고 형식이 올바르지 않습니다.")
	@Column(length = 13)
	@Size(max=13, message="전화번호는 최대 13자리까지 입력가능합니다.")
	private String phone;
	

}
