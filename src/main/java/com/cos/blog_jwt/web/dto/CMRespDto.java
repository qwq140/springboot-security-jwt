package com.cos.blog_jwt.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CMRespDto<T> {
    private int code;
    private String msg;
    private T data;
}
