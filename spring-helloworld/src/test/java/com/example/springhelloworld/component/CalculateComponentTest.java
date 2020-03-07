package com.example.springhelloworld.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// springboot 的测试类
@SpringBootTest
public class CalculateComponentTest {
    // 注入组件
    @Autowired
    private CalculateComponent calculateComponent;

    @Test
    @DisplayName("判断是否有效")
    public void test_add() {
        Assertions.assertEquals(2, calculateComponent.add(1,1));
    }
}
