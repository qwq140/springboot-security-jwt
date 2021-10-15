package com.cos.blog_jwt.web.dto.auth;

import com.cos.blog_jwt.domain.user.User;
import lombok.Data;

@Data
public class JoinDto {
    private String username;
    private String password;
    private String email;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}
