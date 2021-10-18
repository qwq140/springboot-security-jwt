package com.cos.blog_jwt.web.dto.user;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String password;
    private String email;
}
