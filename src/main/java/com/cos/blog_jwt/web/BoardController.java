package com.cos.blog_jwt.web;

import com.cos.blog_jwt.config.auth.PrincipalDetails;
import com.cos.blog_jwt.domain.board.Board;
import com.cos.blog_jwt.service.BoardService;
import com.cos.blog_jwt.web.dto.CMRespDto;
import com.cos.blog_jwt.web.dto.board.BoardReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // 글쓰기
    @PostMapping("/blog/board")
    public CMRespDto<?> save(@RequestBody BoardReqDto boardSaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        Board board = boardSaveReqDto.toEntity();
        board.setUser(principalDetails.getUser());
        return new CMRespDto<>(1,"글쓰기 성공",boardService.글쓰기(board));
    }

    // 글전체조회
    @GetMapping("/blog/board")
    public CMRespDto<?> findAll(){
        return new CMRespDto<>(1,"글전체조회 성공",boardService.전체조회());
    }

    // 글상세조회
    @GetMapping("/blog/board/{id}")
    public CMRespDto<?> findById(@PathVariable int id){
        return new CMRespDto<>(1,"글상세조회 성공",boardService.글상세조회(id));
    }

    // 글수정하기
    @PutMapping("/blog/board/{id}")
    public CMRespDto<?> update(@PathVariable int id, @RequestBody BoardReqDto boardUpdateReqDto){
        return new CMRespDto<>(1,"글수정하기 성공",boardService.글수정하기(id, boardUpdateReqDto));
    }

    // 글삭제하기
    @DeleteMapping("/blog/board/{id}")
    public CMRespDto<?> deleteById(@PathVariable int id){
        boardService.글삭제하기(id);
        return new CMRespDto<>(1,"글삭제하기 성공",null);
    }

}
