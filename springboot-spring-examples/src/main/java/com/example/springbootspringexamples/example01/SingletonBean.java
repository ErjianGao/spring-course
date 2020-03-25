package com.example.springbootspringexamples.example01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 单例组件，无论在哪用，始终是一个对象
@Component
@Slf4j
public class SingletonBean {
    // 自动注入，也可以通过构造函数注入
    @Autowired
    private PrototypeBean prototypeBean;

    public void getProto() {
        log.debug("Prototype in Singleton: {}", prototypeBean);
    }
}
