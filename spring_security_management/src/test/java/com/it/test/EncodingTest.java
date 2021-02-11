package com.it.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123");
        System.out.println(encode);
    }
}
