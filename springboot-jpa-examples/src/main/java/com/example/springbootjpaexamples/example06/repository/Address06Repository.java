package com.example.springbootjpaexamples.example06.repository;

import com.example.springbootjpaexamples.example06.entity.Address06;
import com.example.springbootjpaexamples.repository.BaseRepository;
import org.springframework.stereotype.Repository;

// 组件放到容器里
@Repository
public interface Address06Repository extends BaseRepository<Address06, Integer> {
}
