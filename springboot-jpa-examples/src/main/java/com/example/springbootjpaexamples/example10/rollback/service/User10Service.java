package com.example.springbootjpaexamples.example10.rollback.service;

import com.example.springbootjpaexamples.example10.rollback.entity.User10;
import com.example.springbootjpaexamples.example10.rollback.repository.User10Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Transactional
public class User10Service {
    @Autowired
    private User10Repository user10Repository;

    public void addUser(User10 u) {
        user10Repository.save(u);
        try {
            Files.readString(Path.of("A:/a.a"));
        } catch (IOException e) {
            // 转抛非受检异常，出现时数据库回滚，在业务逻辑中自定义非受检异常
            throw new RuntimeException("run");
        }
    }
}
