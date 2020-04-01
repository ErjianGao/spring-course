package com.example.springbootspringmvcexamples.example04;

import com.example.springbootspringmvcexamples.example04.passwordencoder.service.User04Service;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
public class PasswordEncoderTest {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private User04Service user04Service;

    @Test
    public void test_encoder() {
        String password = "123456";
        String encodePwd = encoder.encode(password);
        log.debug("{}", encodePwd);
        log.debug("{}", encoder.encode(password).getClass());
        log.debug("{}", encoder.encode(password));
        log.debug("{}", encoder.matches(password, encodePwd));
    }

}
