package com.example.sessionEx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sessionEx.dto.UserDTO;

import jakarta.validation.Valid;

@Mapper
public interface IUserDAO {

	UserDTO selectUser(@Param("id") String id, @Param("pw") String pw);

	UserDTO selectUserById(@Param("id") String loginId);
	
	List<UserDTO> getUserList();
	
	List<UserDTO> getUserListWithParam(@Param("user") UserDTO user);

	List<UserDTO> getUserListWithParam2(@Param("user") UserDTO user);

	void insert(@Valid UserDTO user);

}
