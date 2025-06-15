package com.example.demo2.service;


import com.example.demo2.entity.Board;
import com.example.demo2.entity.Member;
import com.example.demo2.repository.BoardRepository;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class TestBoardService {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    BoardService boardService;

    @Test
    void insertBoard(){

    }



    //@Test //Fetch Join문으로 @Transactional 불필요
    void testGetBoardListFetch(){
        List<Board> list = boardRepository.getBoardListWithMember();
        for(Board b : list){
            System.out.println(b.getTitle() + " | " + b.getMember().getUsername());

        }
    }


    //@Test
    @Transactional //어노테이션 트랜잭셔녈 필요
    public void testGetBoardList(){
        List<Board> list = new ArrayList<>();
        list = boardRepository.findAll();
        for(Board b : list){
            System.out.println(b.getTitle() + " | " + b.getMember().getUsername());

        }
    }
    //@Test
    public void insertBoardDummies(){
        IntStream.rangeClosed(1, 10).forEach(i ->{
            Member member = new Member();
            member.setMember_id(1);
            Board board = Board.builder()
                    .title("test title" + i)
                    .content("test content..........." + i)
                    .member(member)
                    .build();
            boardRepository.save(board);
        });
    }
}
