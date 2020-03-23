package com.example.springbootjpaexamples.example06.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User06 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    // 声明为即时加载
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Address06> addresses;
}