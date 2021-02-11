package com.it;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.it.mapper")
public class OauthSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthSourceApplication.class, args);
    }
}
