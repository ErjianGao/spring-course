package com.example.springbootspringmvcexamples.example05.textencryptor.component;

public class MyToken {
    private enum Role {
        ADMIN, USER
    }
    private Role role;
    private Integer uid;
}
