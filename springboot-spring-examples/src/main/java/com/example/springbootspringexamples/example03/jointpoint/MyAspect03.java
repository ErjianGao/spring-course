package com.example.springbootspringexamples.example03.jointpoint;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Aspect
@Slf4j
public class MyAspect03 {
    @Pointcut("execution(* com.example.springbootspringexamples.example03..*.*(..))")
    public void pointcut() {}

    // @Before("pointcut()")
    // 直接注入
    public void before(JoinPoint joinPoint) {
        log.debug(joinPoint.getClass().getName());
        for(Object arg : joinPoint.getArgs()) {
            log.debug("{}", arg);
        }
        log.debug(joinPoint.getSignature().getName());
        log.debug(joinPoint.getThis().getClass().getName());
    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objects = joinPoint.getArgs();
        objects[0] = "sun";
        return joinPoint.proceed(objects);
    }
}
