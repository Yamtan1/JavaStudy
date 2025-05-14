package com.example.theater.qnaDAO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.theater.DAO.IQnaDAO;
import com.example.theater.DTO.QnaDTO;

@SpringBootTest
class qnaDAOTest {

	@Autowired
	IQnaDAO qnadao;
	@Test
	void testInsert() {
		for(int i = 0; i < 100; i++) {
			QnaDTO qna = new QnaDTO();
			qna.setId("qwer1234");
			qna.setQtitle("문의사항테스트" + i);
			qna.setQcontent("문의사항 테스트 중" + i);
			qna.setAnswer(null);
			
			qnadao.insertQna(qna.getId(), qna.getQtitle(), qna.getQcontent());
		}
	}

}