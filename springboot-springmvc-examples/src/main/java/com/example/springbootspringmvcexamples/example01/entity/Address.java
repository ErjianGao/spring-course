package com.example.springbootspringmvcexamples.example01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    private int id;
    private String detail;
    private String comment;
    private LocalDateTime localDateTime;
}
