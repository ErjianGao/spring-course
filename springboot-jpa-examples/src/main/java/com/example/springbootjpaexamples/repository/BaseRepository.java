package com.example.springbootjpaexamples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

// 原来的要有，通用的接口
// 防止spring容器创建对象
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
    void refresh(T t);
}
