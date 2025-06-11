package com.example.demo2.repository;

import com.example.demo2.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TestRepository {

    @Autowired
    MemberRepository memberRepository;

    //@Test
    void deleteMember(){
        int memberId = 1;
        Member m = new Member();
        m.setMember_id(memberId);
        memberRepository.delete(m);
        assertNotNull(m);
    }
    //@Test
    void updateMember(){
        Member m = new Member();
        m.setMember_id(1);
        m.setName("홍길동");
        memberRepository.save(m);
        assertNotNull(m);
    }

    //@Test
    void countMemberTest4(){
        long count = memberRepository.countAllMembersNative();
        assertEquals(4, count);
    }

    //@Test
    void countMemberTest3(){
        long count = memberRepository.countAllMembers();
        assertEquals(4, count);
    }

   // @Test
    void countMemberTest2(){
        long count = memberRepository.countBy();
        assertEquals(4, count);
    }

    //@Test
    void countMemberTest(){
        long count = memberRepository.count();
        assertEquals(4, count);
    }
    @Test
    void insertMemberDummies(){
        IntStream.rangeClosed(4,7).forEach(i ->{
            Member member = Member.builder()
                    .username("user"+ i)
                    .password("1234"+i)
                    .name("user"+i)
                    .phone("010-1234-123"+ i)
                    .build();
            memberRepository.save(member);
        });
    }
}
