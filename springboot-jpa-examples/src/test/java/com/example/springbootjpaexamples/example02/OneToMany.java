package com.example.springbootjpaexamples.example02;

import com.example.springbootjpaexamples.example02.onetomany.Address02;
import com.example.springbootjpaexamples.example02.onetomany.User02;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
public class OneToMany {
    @Autowired
    private EntityManager manager;

    @Test
    public void test_addUserAddress() {
        User02 user = new User02();
        user.setName("BO");
        manager.persist(user);

        Address02 address1 = new Address02();
        address1.setDetail("956");
        manager.persist(address1);

        Address02 address2 = new Address02();
        address2.setDetail("957");
        manager.persist(address2);
    }

    @Test
    public void test_rel() {
        // 到Address02实体类中找主键为1的记录封装成a1对象
        Address02 a1 = manager.find(Address02.class, 1);
        User02 u = manager.find(User02.class, 1);
        // 建立实体类之间的关系，一定是由many端维护，不能由one端维护，不可能将集合放入one端对象
        a1.setUser(u);
        Address02 a2 = manager.find(Address02.class, 3);
        a2.setUser(u);
    }
}
