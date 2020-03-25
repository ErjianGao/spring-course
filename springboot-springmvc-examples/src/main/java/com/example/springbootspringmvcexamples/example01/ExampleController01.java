package com.example.springbootspringmvcexamples.example01;

import com.example.springbootspringmvcexamples.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
// 一个约定，接收请求和返回响应都是json，请求都是带根的，设定目录为根，里面都是相对路径
@RequestMapping("/api/example01/")
public class ExampleController01 {
    // 相对路径，get请求
    @GetMapping("index")
    public Map getIndex() {
        return Map.of("name", "WANG");
    }

    @GetMapping("addresses")
    public Map getAddresses() {
        Address address01 = new Address(1, "956", "a", LocalDateTime.now());
        Address address02 = new Address(2, "956", "b", LocalDateTime.now());
        Address address03 = new Address(3, "956", "c", LocalDateTime.now());
        return Map.of("addresses", List.of(address01, address02, address03));
    }

    // 只要键的名称能对上即可，基于键值对获取值，然后进行后续操作
    @PostMapping("addresses")
    public Map postAddress(@RequestBody Address address) {
        log.debug(address.getDetail());
        log.debug(address.getComment());
        return Map.of(); 
    }
}
