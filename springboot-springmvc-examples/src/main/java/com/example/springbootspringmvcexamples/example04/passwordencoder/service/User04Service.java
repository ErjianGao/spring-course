package com.example.springbootspringmvcexamples.example04.passwordencoder.service;

import com.example.springbootspringmvcexamples.example04.passwordencoder.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Map;

@Service
@Slf4j
public class User04Service {
    private Map<String, User> map = createUser();

    public Map<String, User> createUser() {
        User u = new User();
        u.setUserName("BO");
        String password = "123456";
        u.setPassword("$2a$10$vbic.eN8nCmnzExjVIUUwOKsIAz0.NGEYC/IGwjWJHSCC8s37Kn9G");
        return Map.of("BO", u);
    }

    public User getUser(String userName) {
        return map.get(userName);
    }
}
