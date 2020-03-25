package com.example.springbootspringexamples.example04.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAuthorityAspect {
    // 切所有带注解的方法
    @Around("@annotation(myAuthority)")
    public Object checkMethod(ProceedingJoinPoint proceedingJoinPoint, MyAuthority myAuthority) throws Throwable {
        Object object = proceedingJoinPoint.proceed();
        for(MyAuthority.MyAuthorityType au : myAuthority.value()) {
            log.debug("{}", au);
        }
        return object;
    }

    // 类型的注解，通过反射如果有，如果没有
    @Around("@within(myAuthority)")
    public Object checkType(ProceedingJoinPoint proceedingJoinPoint, MyAuthority myAuthority) throws Throwable {
        Object obj = proceedingJoinPoint.proceed();
        MethodSignature ms = (MethodSignature) proceedingJoinPoint.getSignature();

        if(ms.getMethod().getAnnotation(myAuthority.getClass()) != null) {
            return obj;
        }
        return obj;
    }
}
