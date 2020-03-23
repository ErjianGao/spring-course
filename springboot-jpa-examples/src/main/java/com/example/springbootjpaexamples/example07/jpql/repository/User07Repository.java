package com.example.springbootjpaexamples.example07.jpql.repository;

import com.example.springbootjpaexamples.example07.jpql.entity.User07;
import com.example.springbootjpaexamples.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface User07Repository extends BaseRepository<User07, Integer> {
    // 参数变量用:声明
    @Query("FROM User07 u WHERE u.name=:name")
    List<User07> list(@Param("name") String username);
}
