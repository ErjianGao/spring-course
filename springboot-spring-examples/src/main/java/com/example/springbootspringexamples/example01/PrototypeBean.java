package com.example.springbootspringexamples.example01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 原型组件，在任何需要的地方注入一个单独的对象
@Component
@Slf4j
// 默认为单例模式，声明范围后变为原型模式
@Scope("prototype")
public class PrototypeBean {
    @Autowired
    private SingletonBean singletonBean;

    public void getSingletonBean() {
        log.debug("singleton in prototype: {}", singletonBean);
    }
}
