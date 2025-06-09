package com.example.security.repository;

import com.example.security.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    MemberEntity findByUsername(String username);
}
