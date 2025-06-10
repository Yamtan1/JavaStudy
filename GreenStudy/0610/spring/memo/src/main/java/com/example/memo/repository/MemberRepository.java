package com.example.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.memo.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

}
