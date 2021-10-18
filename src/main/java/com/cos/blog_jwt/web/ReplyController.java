package com.cos.blog_jwt.web;

import com.cos.blog_jwt.config.auth.PrincipalDetails;
import com.cos.blog_jwt.domain.reply.Reply;
import com.cos.blog_jwt.service.BoardService;
import com.cos.blog_jwt.service.ReplyService;
import com.cos.blog_jwt.web.dto.CMRespDto;
import com.cos.blog_jwt.web.dto.reply.ReplySaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReplyController {

    private final BoardService boardService;
    private final ReplyService replyService;

    // 댓글작성
    @PostMapping("/blog/reply")
    public CMRespDto<?> save(@RequestBody ReplySaveReqDto replySaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        Reply reply = replySaveReqDto.toEntity();
        reply.setBoard(boardService.글상세조회(replySaveReqDto.getBoardId()));
        reply.setUser(principalDetails.getUser());

        return new CMRespDto<>(1,"댓글작성 성공",replyService.댓글쓰기(reply));
    }

    // 댓글삭제
    @DeleteMapping("/blog/reply/{id}")
    public CMRespDto<?> deleteById(@PathVariable int id){
        replyService.댓글삭제(id);
        return new CMRespDto<>(1,"댓글삭제 성공",null);
    }
}
