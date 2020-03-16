package com.example.springbootjpaexamples.example05;

import com.example.springbootjpaexamples.example05.entity.User05;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 使用持久层注解，声明接口，通过反射动态代理自动生成实现类
@Repository
public interface User05Repositoey extends JpaRepository<User05, Integer> {

}
