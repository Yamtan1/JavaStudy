package com.example.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ex_member")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member extends BaseEntity {

    @Id
    @Column(length = 20)
    @Size(min = 5, max = 20, message = "아이디는 5~20글자 사이여야 합니다.")
    private String id;
    @Column(length = 20)
    @Size(min = 6, max = 20, message = "비밀번호는 6~20글자 사이여야합니다.")
    private String pw;
    private String name;
    @Size(max = 13)
    @Pattern(regexp = "^010-\\d{4}-\\d{4}$")
    private String phone;
}
