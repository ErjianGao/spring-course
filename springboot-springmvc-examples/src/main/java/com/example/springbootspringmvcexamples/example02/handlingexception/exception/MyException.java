package com.example.springbootspringmvcexamples.example02.handlingexception.exception;

public class MyException extends RuntimeException {
    public MyException(String message) {
        // 调用父类的构造函数
        super(message);
    }
}
