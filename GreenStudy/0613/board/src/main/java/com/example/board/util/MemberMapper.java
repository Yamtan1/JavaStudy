package com.example.board.util;

import com.example.board.dto.MemberDto;
import com.example.board.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member toEntity(MemberDto member){
        //DTO 를 엔티티로 변환
        Member m = new Member();
        m.setId(member.getId());
        m.setPw(member.getPw());
        m.setName(member.getName());
        m.setPhone(member.getPhone());

        return m;
    }

}
