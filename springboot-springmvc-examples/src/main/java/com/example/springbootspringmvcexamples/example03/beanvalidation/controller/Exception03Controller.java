package com.example.springbootspringmvcexamples.example03.beanvalidation.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.Set;

@Slf4j
// 不是普通的controller组件
@RestControllerAdvice
public class Exception03Controller {
    /**
     * 属性校验失败异常，例如长度不符
     *
     * @param exception 注入的异常
     * @return
     */
    // 声明要处理哪一个异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    // 返回的状态码
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map handleValidException(MethodArgumentNotValidException exception) {
        StringBuilder strBuilder = new StringBuilder();
        // getBindingResult: 获取绑定的结果
        // getFieldErrors: 获取校验属性失败信息
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(e -> {
                    // 校验失败属性名称
                    strBuilder.append(e.getField());
                    strBuilder.append(": ");
                    // 失败描述信息
                    strBuilder.append(e.getDefaultMessage());
                    strBuilder.append("; ");
                });
        return Map.of("message", strBuilder.toString());
    }


    /**
     * 请求类型转换失败异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    // 获取到异常对象和Servlet请求对象
    public Map handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception,
            HttpServletRequest request) {
        // 获取请求路径和错误信息
        String msg = request.getRequestURI() +
                ": " + "请求地址参数" + exception.getValue() + "错误";
        return Map.of("message", msg);
    }

    /**
     * jackson json类型转换异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map handleInvalidFormatException(InvalidFormatException exception) {
        StringBuilder strBuilder = new StringBuilder();
        exception.getPath()
                .forEach(p -> {
                    strBuilder.append("属性");
                    strBuilder.append(p.getFieldName());
                    strBuilder.append("，您输入的值：" + exception.getValue());
                    strBuilder.append(", 类型错误！");
                });
        return Map.of("message", strBuilder.toString());
    }


    /**
     * 方法级参数校验失败异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map handleConstraintViolationException(ConstraintViolationException exception) {
        StringBuilder strBuilder = new StringBuilder();
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        violations.forEach(v -> {
            strBuilder.append(v.getMessage() + "; ");
        });
        return Map.of("message", strBuilder.toString());
    }
}