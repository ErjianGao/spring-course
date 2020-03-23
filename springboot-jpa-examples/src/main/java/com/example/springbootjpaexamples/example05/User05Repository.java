package com.example.springbootjpaexamples.example05;

import com.example.springbootjpaexamples.example05.entity.User05;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 使用持久层注解，声明接口，对User05进行操作的接口，通过spring-data反射动态代理自动创建实现类
// 必须继承自JpaRepository，将泛型改为实体类型，和ID类型
@Repository
public interface User05Repository extends JpaRepository<User05, Integer> {

}
