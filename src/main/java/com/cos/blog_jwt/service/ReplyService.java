package com.cos.blog_jwt.service;

import com.cos.blog_jwt.domain.reply.Reply;
import com.cos.blog_jwt.domain.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Transactional
    public Reply 댓글쓰기(Reply reply){
        return replyRepository.save(reply);
    }

    @Transactional
    public void 댓글삭제(int id){
        replyRepository.deleteById(id);
    }

}
