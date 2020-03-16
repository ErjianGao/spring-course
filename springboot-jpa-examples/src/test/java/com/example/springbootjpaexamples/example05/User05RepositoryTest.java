package com.example.springbootjpaexamples.example05;

import com.example.springbootjpaexamples.example01.User;
import com.example.springbootjpaexamples.example05.entity.User05;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
// 所有的public方法都是支持事务的
@Transactional
@Rollback(value = false)
public class User05RepositoryTest {
    @Autowired
    private User05Repositoey user05Repositoey;

    @Test
    public void test_addUser() {
        // 新建状态
        User05 user05 = new User05();
        user05.setName("BO");
        // save()对没有主键的对象执行新建，对有id的执行更新 把新建对象对象放入持久化上下文中，只有方法结束，事务才结束，数据才能插入数据库
        user05Repositoey.save(user05);
        user05.setName("SUN");
        // 这个状态改变没用，因为当对象处于持久化上下文中时，对对象的更改自动同步到数据库中
        user05Repositoey.save(user05);
        log.debug("dawdwa");
    }

    @Test
    public void test_addUser2() {
        // 此方法返回Optional对象，因为根据ID获取对象有可能返回的结果为空
        // 只要被这个接口中的方法操作，就自动变到持久化上下文中，然后操作自动同步
        User05 user05 = user05Repositoey.findById(1).orElse(null);
        assert user05 != null;
        user05.setName("SUn");
    }

    @Test
    public void test_addUser3() {
        User05 user05 = new User05();
        user05.setId(2);
        // 只把对对象的所有修改同步到数据库
        user05Repositoey.save(user05);
    }

    @Test
    public void test_addUser4() {
        // 新建状态同步到undo的表里，唯一能拿到的是主键
        User05 user05 = new User05();
        user05.setName("BO");
        // 只把对对象的所有修改同步到数据库
        user05Repositoey.save(user05);
        log.debug("{}", user05.getId());
        // 时间戳等数据库自己生成的回不来
        log.debug("{}", user05.getName());
    }
}
