package com.example.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mybatis.dto.MemberDTO;

@Mapper
public interface IMemberDAO {
	
	//@Select("SELECT * FROM tbl_member")
	List<MemberDTO> getList();
	
	//@Select("SELECT * FROM tbl_member WHERE id= #{id}")
	MemberDTO getMember(@Param("id") String id);
	
	//@Update("UPDATE tbl_member SET name= #{m.name}, phone= #{m.phone}, pw= #{m.pw}, grade= #{m.grade} WHERE id= #{m.id}")
	void update(@Param("m") MemberDTO member);
	
	//@Delete("DELETE FROM tbl_member WHERE id = #{id}")
	void delete(@Param("id") String id);
	
	void insert(MemberDTO member);
}
