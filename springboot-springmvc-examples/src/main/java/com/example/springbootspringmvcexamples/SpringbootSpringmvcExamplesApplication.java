package com.example.springbootspringmvcexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class SpringbootSpringmvcExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringmvcExamplesApplication.class, args);
    }

    // 方法级Bean注解
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        // 返回的对象需要注入Spring容器中，然后这个对象会去处理Controller中的方法级校验失败处理
        return new MethodValidationPostProcessor();
    }
}
