package com.example.memo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.memo.entity.MemberEntity;

@SpringBootTest
class MemberTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	void insertMember() {
		MemberEntity m = new MemberEntity();
		m.setUsername("실홈중입니다");
		m.setName("실험용");
		m.setPw("qwer1234!");
		m.setPhone("010-2123-3425");
		MemberEntity result = memberRepository.save(m);
		assertNotNull(result);	
	}
	//@Test
	void updateMember() {
		MemberEntity m = new MemberEntity();
		m.setId(1);
		m.setUsername("수정햇");
		m.setName("수정용");
		m.setPw("qwer1234!");
		m.setPhone("010-2323-4425");
		MemberEntity result = memberRepository.save(m);
		assertNotNull(result);
	}
	//@Test
	void deleteMember() {
		MemberEntity m = new MemberEntity();
		m.setId(1);
		memberRepository.delete(m);
	}
	//@Test
	void selectMember() {
	    int id = 2; // 조회할 회원 ID (기존에 저장된 ID여야 함)
	    MemberEntity m = memberRepository.findById(id).orElse(null);
	    assertNotNull(m);
	    System.out.println("조회된 사용자명: " + m.getUsername());
	}
	//@Test
	void selectMember2() {
		Integer id = 2;
		memberRepository.findById(id).ifPresentOrElse(
				member -> System.out.println(member),
				() ->  System.out.println("해당해원을 찾을 수 없습니다")
				);
	}
	//@Test
	void testSelect3() {
		Integer id = 2;
		try {
			MemberEntity m = memberRepository.findById(id)
							.orElseThrow(() -> new NoSuchElementException("회원이 존재하지 않습니다"));
			System.out.println(m);
		}catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
