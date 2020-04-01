package com.example.springbootspringmvcexamples;

import com.example.springbootspringmvcexamples.example06.interceptor.interceptor.AdminInterceptor06;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// mvc配置，重写方法
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    // 将拦截器注入
    @Autowired
    private AdminInterceptor06 adminInterceptor06;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截、通过规则
        registry.addInterceptor(adminInterceptor06)
                .addPathPatterns("/api/example06/admin/**");
    }
}
