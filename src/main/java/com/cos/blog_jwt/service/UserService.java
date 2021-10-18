package com.cos.blog_jwt.service;

import com.cos.blog_jwt.domain.user.User;
import com.cos.blog_jwt.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void 회원정보조회(){}

    public void 회원정보수정(){}

    public void 회원탈퇴(){}

}
