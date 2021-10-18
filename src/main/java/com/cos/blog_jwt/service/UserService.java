package com.cos.blog_jwt.service;

import com.cos.blog_jwt.domain.user.User;
import com.cos.blog_jwt.domain.user.UserRepository;
import com.cos.blog_jwt.handler.ex.CustomApiException;
import com.cos.blog_jwt.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User 회원가입(User user){
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRoles("ROLE_USER");
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> 모든회원조회(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User 회원정보조회(int id){
        return userRepository.findById(id).orElseThrow(()->{
            throw new CustomApiException("유저를 찾을 수 없습니다.");
        });
    }

    @Transactional
    public User 회원정보수정(int id, UserUpdateDto userUpdateDto){
        User userEntity = userRepository.findById(id).orElseThrow(()->{
            throw new CustomApiException("유저를 찾을 수 없습니다.");
        });

        String rawPassword = userUpdateDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        userEntity.setPassword(encPassword);
        userEntity.setEmail(userUpdateDto.getEmail());

        return userEntity;
    }

    @Transactional
    public void 회원탈퇴(int id){
        userRepository.deleteById(id);
    }

}
