package com.example.springbootspringexamples.example04.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 运行时注解
@Retention(RetentionPolicy.RUNTIME)
// 使用目标，可以放在类型级 方法级
@Target({ElementType.TYPE, ElementType.METHOD})
// 自定义注解，定义时可以有元注解
public @interface MyAuthority {
    // 声明默认注解
    MyAuthorityType[] value() default MyAuthorityType.USER;

    // 定义枚举
    enum MyAuthorityType {
        USER, ADMIN, SUPER_ADMIN
    }
}
