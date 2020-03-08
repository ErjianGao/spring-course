package com.example.springbootjpaexamples.example04;

import com.example.springbootjpaexamples.example04.manytomany.Course04;
import com.example.springbootjpaexamples.example04.manytomany.Elective;
import com.example.springbootjpaexamples.example04.manytomany.Student04;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.NameMangler;
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
public class ManyToManyTest {
    @Autowired
    private EntityManager manager;

    @Test
    public void test_init() {
        Student04 s1 = new Student04();
        s1.setName("BO");
        manager.persist(s1);
        Student04 s2 = new Student04();
        s2.setName("GAO");
        manager.persist(s2);

        Course04 c1 = new Course04();
        c1.setName("frame work of web development");
        manager.persist(c1);
    }

    @Test
    public void test_rel() {
        Student04 s = manager.find(Student04.class, 2);
        Course04 c = manager.find(Course04.class, 1);

        // 中间表
        Elective e = new Elective();
        e.setStudent(s);
        e.setCourse(c);
        e.setDetail("我选了web框架");
        manager.persist(e);
    }
}
