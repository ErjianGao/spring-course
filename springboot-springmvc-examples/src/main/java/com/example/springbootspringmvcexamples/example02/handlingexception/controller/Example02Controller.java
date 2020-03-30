package com.example.springbootspringmvcexamples.example02.handlingexception.controller;

import com.example.springbootspringmvcexamples.example02.handlingexception.entity.User;
import com.example.springbootspringmvcexamples.example02.handlingexception.exception.UnauthorizedException;
import com.example.springbootspringmvcexamples.example02.handlingexception.service.UserService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example02/")
public class Example02Controller {
    @Autowired
    private UserService02 userService02;

    @GetMapping("exception02")
    public void getException02() {
        userService02.addFile2();
    }

    @PostMapping("login")
    public void login(@RequestBody User user) {
        if (!(user.getUserName().equals("BO") && user.getPassword().equals("123456"))) {
            // throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名密码错误");
            throw new UnauthorizedException();
        }
    }
}
