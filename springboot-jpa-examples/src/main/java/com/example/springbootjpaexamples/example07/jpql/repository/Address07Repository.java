package com.example.springbootjpaexamples.example07.jpql.repository;

import com.example.springbootjpaexamples.example07.jpql.entity.Address07;
import com.example.springbootjpaexamples.example07.jpql.entity.User07;
import com.example.springbootjpaexamples.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Address07Repository extends BaseRepository<Address07, Integer> {
    @Query("SELECT a.user FROM Address07 a WHERE a.detail=:detail")
    List<User07> list(@Param("detail") String detail);

    @Query("SELECT a.user FROM Address07 a WHERE a.user.id=:uid")
    User07 find(@Param("uid") int uid);

    // 类型不安全，所以要经过严格的测试
    @Query("FROM Address07 a WHERE a.detail=:detail AND a.user.name=:name")
    List<Address07> list(@Param("detail") String detail, @Param("name") String username);

    // 返回结果封装到Page
    @Query("FROM Address07 a WHERE a.detail=:detail")
    Page<Address07> list(@Param("detail") String detail, Pageable pageable);
}
