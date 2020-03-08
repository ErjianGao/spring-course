package com.example.springbootjpaexamples.example01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Slf4j
// 数据的插入必须用到事务
@Transactional
// 默认的测试会有一个回滚，插入的数据(事务)在测试中直接撤销，所以为了看到变化，关闭自动回滚，在类中注入持久化管理器
@Rollback(value = false)
public class UserTest {
    // 自动注入实体管理器，一个接口
    @Autowired
    private EntityManager manager;

    @Test
    public void test_addUser() {
        User user = new User();
        user.setName("BO");
        // 通过管理器方法插入
        manager.persist(user);
        log.debug("{}", user.getId());
    }
}
