package com.example.springbootspringexamples.example04;

import com.example.springbootspringexamples.example04.aop.AOPService04;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.SocketOption;

@SpringBootTest
@Slf4j
public class AOPAuthorityTest {
    @Autowired
    private AOPService04 aopService04;

    @Test
    public void test_checkType() {

    }

    @Test
    public void test_getUser() {
        // around切面，输出权限名称
        aopService04.getAdmin();
    }
}
