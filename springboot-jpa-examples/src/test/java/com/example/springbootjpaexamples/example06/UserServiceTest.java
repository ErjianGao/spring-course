package com.example.springbootjpaexamples.example06;

import com.example.springbootjpaexamples.example06.entity.Address06;
import com.example.springbootjpaexamples.example06.entity.User06;
import com.example.springbootjpaexamples.example06.repository.Address06Repository;
import com.example.springbootjpaexamples.example06.repository.User06Repository;
import com.example.springbootjpaexamples.example06.service.User06Service;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
// 整合测试，整合持久化单元与业务逻辑
// 如果开发环境的话现在不用加回滚false
public class UserServiceTest {
    @Autowired
    // 已经包含事务，所以Test不需要声明
    private User06Service user06Service;

    @Test
    public void init() {
        // 创建user
        User06 u = new User06();
        u.setName("BO");
        user06Service.addUser(u);

        // 创建地址
        Address06 address01 = new Address06();
        address01.setDetail("956");
        // Many端维护关系，声明关系
        address01.setUser(u);
        user06Service.addAddress(address01);

        Address06 address02 = new Address06();
        address02.setDetail("957");
        address02.setUser(u);
        user06Service.addAddress(address02);
    }

    @Test
    public void test_fetch() {
        // 事务在完成业务逻辑操作之后已经结束
        log.debug(user06Service.getAddress(1).getUser().getName());
    }

    @Test
    public void test_fetch2() {
        // 默认为懒加载，已强制改为即时加载
        user06Service.getUser(1)
                .getAddresses()
                .forEach(a -> log.debug(a.getDetail()));
    }
}
