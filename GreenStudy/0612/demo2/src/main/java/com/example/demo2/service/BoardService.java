package com.example.demo2.service;

import com.example.demo2.entity.Board;
import com.example.demo2.entity.Member;
import com.example.demo2.repository.BoardRepository;
import com.example.demo2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    MemberRepository memberRepository;

    public List<Board> getBoardList(){
        List<Board> list = boardRepository.findAll();
        return list;
    }
    public void insertBoard(Board board) {
        Member m = new Member();
        m.setMember_id(2);
        board.setTitle("서비스로 넣기");
        board.setContent("서비스 클래스로 하는중");
        board.setMember(m);
        boardRepository.save(board);
    }
}
