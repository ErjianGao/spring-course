package com.example.springbootjpaexamples.example02.onetomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Address02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // UUID有点麻烦
    private int id;
    private String detail;

    // 一个地址对应一个人，实体类中使用复合属性需要声明关系
    @ManyToOne
    private User02 user;
}
