package com.example.springbootjpaexamples.example02.onetomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // UUID有点麻烦
    private int id;
    private String name;
    // 显式声明放弃了关系的维护权(mappedBy)，声明自己在关系的另一方对象叫什么
    @OneToMany(mappedBy = "user")
    // 如果使用Set集合，默认无序，并且没有重复对象
    private List<Address02> addresses;
}
