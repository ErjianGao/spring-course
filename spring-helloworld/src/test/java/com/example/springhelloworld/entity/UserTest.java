package com.example.springhelloworld.entity;

import com.example.springhelloworld.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.naming.Name;

@Slf4j
public class UserTest {
    @Test
    public void test_get() {
        User user = new User();
        user.setName("BO");
        UserService.get(user.getName());
    }
}
