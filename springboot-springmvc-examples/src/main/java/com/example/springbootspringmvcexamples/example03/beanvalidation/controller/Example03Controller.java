package com.example.springbootspringmvcexamples.example03.beanvalidation.controller;

import com.example.springbootspringmvcexamples.example03.beanvalidation.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Map;

@RestController
@RequestMapping("/example03/")
// 注意在进行方法级校验时必须加这个注解
@Validated
public class Example03Controller {
    @PostMapping("users")
    // 注意一定要加@Valid注解，否则无法启动
    public Map postUser(@Valid @RequestBody User user) {
        return Map.of();
    }

    @GetMapping("users/{uid}/file")
    public void getTypeMismatchException(@PathVariable int uid) {
    }

    // 方法级校验
    // 1. controller中@Validated注解
    // 2. ExceptionController中异常消息返回格式
    // 3. Application文件中声明组件，将返回的处理器对象注入容器
    @GetMapping("users/{owner}")
    public void getViolationException(
            @Size(min = 2, max = 6, message = "用户信息错误") @PathVariable String owner) {
    }
}
