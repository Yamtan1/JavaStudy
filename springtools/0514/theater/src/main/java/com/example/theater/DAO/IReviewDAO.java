package com.example.theater.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.theater.DTO.ReviewDTO;

@Mapper
public interface IReviewDAO {

	void insert(@Param("id")String id, @Param("content")String content);

	List<ReviewDTO> selectReview();



}
