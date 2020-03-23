package com.example.springbootjpaexamples.repository.impl;

import com.example.springbootjpaexamples.repository.BaseRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

// SimpleJpaRepository实现了所有方法，因为注入了实体管理器
public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
    private EntityManager manager;

    // 声明一个构造函数
    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.manager = entityManager;
    }

    // 实现需要实体管理器
    @Override
    public void refresh(T t) {
        manager.refresh(t);
    }
}
