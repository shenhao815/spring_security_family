package com.itheima.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Secured({"ROLE_ORDER","ROLE_ADMIN"})
    @RequestMapping("/findAll")
    public String findAll(){
        return "order-list";
    }
}
