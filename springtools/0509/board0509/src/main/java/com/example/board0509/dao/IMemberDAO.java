package com.example.board0509.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.board0509.dto.MemberDTO;



@Mapper
public interface IMemberDAO {
	
	void memberInsert(MemberDTO member);
	
	int login(@Param("id") String id, @Param("pw") String pw);
	
		

}
