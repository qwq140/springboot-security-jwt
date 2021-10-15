package com.cos.blog_jwt.config.jwt;

public interface JwtProperties {
    String SECRET = "JAP";
    int EXPIATION_TIME = 60000*10; // 10분
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
