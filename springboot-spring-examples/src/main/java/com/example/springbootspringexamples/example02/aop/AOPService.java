package com.example.springbootspringexamples.example02.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

// service层组件
@Service
@Slf4j
public class AOPService {
    public void get() {
        log.debug("AOPService");
    }
}
