package com.example.theater.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.theater.DTO.MemberDTO;

@Mapper
public interface IMemberDAO {

	int selectId(String id);

	void insertMember(@Param("id") String id,@Param("pw") String pw,@Param("name") String name,@Param("phone") String phone, @Param("grade") String grade);

	MemberDTO loginmember(@Param("id") String id, @Param("pw") String pw);
	
	

}
