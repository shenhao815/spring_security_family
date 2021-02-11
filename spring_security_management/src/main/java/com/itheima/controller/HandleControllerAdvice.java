package com.itheima.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class HandleControllerAdvice {

    @ExceptionHandler(AccessDeniedException.class)
    public String handler403(){
        return "forward:/403.jsp"; // 不加forward或redirect就会走视图解析器
    }

    @ExceptionHandler(RuntimeException.class)
    public String handler500(){
        return "forward:/500.jsp";
    }
}
