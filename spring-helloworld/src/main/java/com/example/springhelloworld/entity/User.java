package com.example.springhelloworld.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // lombok会在编译的时候自己生成getter setter，所以需要使用lombok插件
    private String name;
}
