package com.example.springhelloworld.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {
    public static void get(String name) {
        int length = 5;
        if (name.length() <= length) {
            log.debug("{}", "长度小于5");
        }
    }
}
