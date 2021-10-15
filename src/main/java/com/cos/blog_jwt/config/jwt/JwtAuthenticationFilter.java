package com.cos.blog_jwt.config.jwt;

import com.cos.blog_jwt.domain.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            // username, password 받기
            ObjectMapper om = new ObjectMapper(); // json 파싱
            User user = om.readValue(request.getInputStream(),User.class);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            // PrincipalDetailsService loadUserByUsername() 함수가 실행된 후 정상이면 authentication 리턴
            // DB에 있는 username과 password가 일치한다.
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
