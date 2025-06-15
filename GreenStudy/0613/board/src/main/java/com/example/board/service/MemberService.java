package com.example.board.service;

import com.example.board.dto.MemberDto;
import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import com.example.board.util.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberMapper memberMapper;

    public void insertMember(MemberDto member){
        Member m = memberMapper.toEntity(member);
        try{
            Member saved = memberRepository.save(m);
            if(saved != null){
                System.out.println("회원가입 성공");
            }else{
                System.out.println("회원가입 실패");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean loginUser(MemberDto member) {

        Member loginMember = memberRepository.findByIdAndPw(member.getId(), member.getPw());

        if (loginMember != null) {
            System.out.println("로그인 성공!");
            return true;
        } else {
            System.out.println("로그인 실패: ID/PW 불일치");
            return false;
        }
    }

    }

