package com.example.springbootspringexamples.example02;

import com.example.springbootspringexamples.example02.aop.AOPService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AOPServiceTest {
    @Autowired
    private AOPService aopService;

    @Test
    public void test_get() {
        aopService.get();
        log.debug("{}", aopService.getClass().getName());
        // EnhancerBySpringCGLIB 动态生成代理类的对象
    }
}
