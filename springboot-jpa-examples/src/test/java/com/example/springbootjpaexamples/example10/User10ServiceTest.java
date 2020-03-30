package com.example.springbootjpaexamples.example10;

import com.example.springbootjpaexamples.example01.User;
import com.example.springbootjpaexamples.example10.rollback.entity.User10;
import com.example.springbootjpaexamples.example10.rollback.service.User10Service;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
public class User10ServiceTest {
    // 注入业务逻辑方法
    @Autowired
    private User10Service user10Service;

    @Test
    public void test_addUser() {
        User10 user01 = new User10();
        user01.setName("1");
        // Hibernate 将JDBC的受检异常进行了封装
        user10Service.addUser(user01);
    }
}
