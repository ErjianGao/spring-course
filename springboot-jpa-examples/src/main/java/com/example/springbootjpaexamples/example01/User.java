package com.example.springbootjpaexamples.example01;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

// @Table 可以避免冲突，实体类名称与数据表名称
@Data
@NoArgsConstructor
// 声明为实体类
@Entity
public class User {
    // 必须有唯一标识符
    @Id
    // // 自动生成主键，自增长
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private int id;
    // 自动生成主键，托管状态
    @GeneratedValue
    // 如果不显式声明的话，默认长度为255字节，太大了，只需要16字节即可
    // name insertable updatable unique唯一约束 columnDefinition
    @Column(length = 16)
    private UUID id;
    private String name;
    private LocalDate birthday;
    // 映射为时间戳，自动存入当前的时间，业务逻辑层不能插入和更改
    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false, updatable = false)
    private LocalDate insertTime;
    // 更新的时候按时间戳更新，减少业务逻辑层面操作，把时间戳交给数据库执行
    @Column(columnDefinition = "timestamp default current_timestamp " +
            "on update current_timestamp",
            insertable = false, updatable = false)
    private LocalDate updateTime;

}
