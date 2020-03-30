package com.example.springbootspringmvcexamples.example02.handlingexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// 可以自定义未授权的非受检异常
public class UnauthorizedException extends ResponseStatusException {
    public static final String UNAUTHORIZED = "未登录";
    // 重写构造方法
    public UnauthorizedException() {
        super(HttpStatus.UNAUTHORIZED, UNAUTHORIZED);
    }
}
