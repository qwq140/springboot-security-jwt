package com.cos.blog_jwt.handler;


import com.cos.blog_jwt.handler.ex.CustomApiException;
import com.cos.blog_jwt.web.dto.CMRespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomApiException.class)
    public CMRespDto<?> apiException(CustomApiException e){
        return new CMRespDto<>(-1,e.getMessage(),null);
    }

}
