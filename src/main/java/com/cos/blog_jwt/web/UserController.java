package com.cos.blog_jwt.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    // 회원정보조회
    @GetMapping("/blog/user/{id}")
    public void findById(){

    }

    // 회원정보수정
    @PutMapping("/blog/user/{id}")
    public void update(){

    }

    // 회원탈퇴
    @DeleteMapping("/blog/user/{id}")
    public void delete(){

    }

}
