package com.example.springbootjpaexamples;

import com.example.springbootjpaexamples.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 使用BaseRepository，不基于原生jpa，所以要声明
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
@SpringBootApplication
public class SpringbootJpaExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaExamplesApplication.class, args);
    }
}
