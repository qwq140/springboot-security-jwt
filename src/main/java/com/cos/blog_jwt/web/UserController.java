package com.cos.blog_jwt.web;

import com.cos.blog_jwt.config.auth.PrincipalDetails;
import com.cos.blog_jwt.domain.user.User;
import com.cos.blog_jwt.service.UserService;
import com.cos.blog_jwt.web.dto.CMRespDto;
import com.cos.blog_jwt.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    // 모든 회원정보 조회
    @GetMapping("/blog/user")
    public CMRespDto<?> findAll(){
        return new CMRespDto<>(1,"모든회원조회 성공",userService.모든회원조회());
    }

    // 회원정보조회
    @GetMapping("/blog/user/{id}")
    public CMRespDto<?> findById(@PathVariable int id){
        return new CMRespDto<>(1,"회원정보조회 성공",userService.회원정보조회(id));
    }

    // 회원정보수정
    @PutMapping("/blog/user/{id}")
    public CMRespDto<?> update(@PathVariable int id, @RequestBody UserUpdateDto userUpdateDto,@AuthenticationPrincipal PrincipalDetails principalDetails){
        if (principalDetails.getUser().getId() == id){
            User userEntity = userService.회원정보수정(id, userUpdateDto);
            principalDetails.setUser(userEntity);
            return new CMRespDto<>(1,"회원정보수정 성공",userEntity);
        } else {
            return new CMRespDto<>(-1,"회원정보수정 실패",null);
        }
    }

    // 회원탈퇴
    @DeleteMapping("/blog/user/{id}")
    public CMRespDto<?> delete(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails){
        if (principalDetails.getUser().getId() == id){
            userService.회원탈퇴(id);
            return new CMRespDto<>(1,"회원탈퇴 성공",null);
        } else {
            return new CMRespDto<>(-1,"회원탈퇴 실패",null);
        }
    }
}
