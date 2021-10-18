package com.cos.blog_jwt.service;

import com.cos.blog_jwt.domain.board.Board;
import com.cos.blog_jwt.domain.board.BoardRepository;
import com.cos.blog_jwt.web.dto.board.BoardReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board 글쓰기(Board board){
        return boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public List<Board> 전체조회(){
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Board 글상세조회(int id){
        return boardRepository.findById(id).get();
    }

    @Transactional
    public Board 글수정하기(int id, BoardReqDto boardUpdateReqDto){
        Board boardEntity = boardRepository.findById(id).get();

        boardEntity.setTitle(boardUpdateReqDto.getTitle());
        boardEntity.setContent(boardUpdateReqDto.getContent());

        return boardEntity;
    }

    @Transactional
    public void 글삭제하기(int id){
        boardRepository.deleteById(id);
    }

}
