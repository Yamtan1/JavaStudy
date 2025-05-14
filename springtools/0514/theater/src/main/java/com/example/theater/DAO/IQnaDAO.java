package com.example.theater.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.theater.DTO.QnaDTO;

@Mapper
public interface IQnaDAO {

	void insertQna(@Param("id")String id,@Param("qtitle") String qtitle,@Param("qcontent") String qcontent);

	List<QnaDTO> getQnaList(@Param("startRow")int startRow, @Param("endRow") int endRow);

	int ListCount();

	QnaDTO selectView(@Param("id")String id,@Param("qtitle") String qtitle,@Param("qcontent") String qcontent, @Param("qdate") String qdate);

	void updateAnswer(@Param("id")String id,@Param("qtitle") String qtitle,@Param("qcontent") String qcontent, @Param("qdate") String qdate, @Param("answer") String answer);
	

}
