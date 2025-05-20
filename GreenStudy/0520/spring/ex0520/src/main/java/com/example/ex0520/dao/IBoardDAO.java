package com.example.ex0520.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.ex0520.dto.BoardDTO;

import jakarta.validation.Valid;

@Mapper
public interface IBoardDAO {

	void insert(@Valid BoardDTO board);

}
