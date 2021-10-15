package com.cos.blog_jwt.web;

import com.cos.blog_jwt.service.UserService;
import com.cos.blog_jwt.web.dto.CMRespDto;
import com.cos.blog_jwt.web.dto.auth.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/join")
    public CMRespDto<?> join(@RequestBody JoinDto joinDto){
        return new CMRespDto<>(1,"회원가입 성공",userService.회원가입(joinDto.toEntity()));
    }

}
