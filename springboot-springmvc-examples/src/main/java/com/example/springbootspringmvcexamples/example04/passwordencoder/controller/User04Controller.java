package com.example.springbootspringmvcexamples.example04.passwordencoder.controller;

import com.example.springbootspringmvcexamples.example04.passwordencoder.entity.User;
import com.example.springbootspringmvcexamples.example04.passwordencoder.service.User04Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example04/")
public class User04Controller {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private User04Service user04Service;

    @PostMapping("login")
    public Map login(@RequestBody User user) {
        // 先查询用户是否存在
        User u = user04Service.getUser(user.getUserName());
        if (u == null || !encoder.matches(user.getPassword(), u.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名密码错误");
        } else {
            // 登陆成功
            log.debug("登录成功");
        }
        return Map.of("user", u);
    }
}
