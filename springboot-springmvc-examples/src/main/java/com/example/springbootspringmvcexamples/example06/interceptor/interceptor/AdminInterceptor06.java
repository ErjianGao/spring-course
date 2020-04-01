package com.example.springbootspringmvcexamples.example06.interceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
// 实现接口（重写抽象类方法），只负责实现，路径在配置中声明
public class AdminInterceptor06 implements HandlerInterceptor {
    @Override
    // 在之前调用，如果允许进入则返回true，不允许则返回false
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("AdminInterceptor06");
        return false;
    }
}
