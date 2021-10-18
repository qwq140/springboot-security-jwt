package com.cos.blog_jwt.web.dto.reply;

import com.cos.blog_jwt.domain.reply.Reply;
import lombok.Data;

@Data
public class ReplySaveReqDto {

    private String content;
    private int boardId;

    public Reply toEntity(){
        return Reply.builder()
                .content(content)
                .build();
    }

}
