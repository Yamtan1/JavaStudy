package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.MemberRepository;
import com.example.board.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/boardPage")
    public String boardPage(Model model){
        List<Board> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "board/boardPage";
    }

    @GetMapping("/writeBoardPage")
    public String writeBoardPage(){
        return "board/writeBoardPage";
    }

    @PostMapping("/writeBoard")
    public String writeBoard(Board board, HttpSession session){
        List<Board> list = boardService.getBoardList();
        String loginId = (String) session.getAttribute("loginId");
        Member writer = memberRepository.findById(loginId).orElse(null);
        board.setMember(writer);
        boardService.insertBoard(board);
        list.add(board);
        return "redirect:/board/boardPage";
    }
    }

