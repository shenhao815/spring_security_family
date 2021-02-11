package com.it.controller.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerControllerException {

    @ExceptionHandler(RuntimeException.class)
    public String handException(RuntimeException e) {
        if (e instanceof AccessDeniedException) {
            return "forward:/403.jsp";
        } else {
            return "forward:/500.jsp";
        }
    }
}
