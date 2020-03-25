package com.example.springbootspringexamples.example04.aop;

import com.example.springbootspringexamples.example04.aop.MyAuthority;
import org.springframework.stereotype.Component;

@Component
@MyAuthority
public class AOPService04 {
    // 用户级可以执行
    public void getUser() {

    }

    // 通过自定义权限注解声明权限
    @MyAuthority(value = MyAuthority.MyAuthorityType.ADMIN)
    public void getAdmin() {

    }
}
