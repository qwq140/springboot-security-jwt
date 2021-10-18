package com.cos.blog_jwt.web.dto.board;

import com.cos.blog_jwt.domain.board.Board;
import lombok.Data;

@Data
public class BoardReqDto {

    private String title;
    private String content;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

}
