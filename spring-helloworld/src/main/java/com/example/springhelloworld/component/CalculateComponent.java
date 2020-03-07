package com.example.springhelloworld.component;

import org.springframework.stereotype.Component;

// 声明一个组件
@Component
public class CalculateComponent {
    public int add(int x, int y) {
        return x+y;
    }
}
