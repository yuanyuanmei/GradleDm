package com.example.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan("com.example.*.dao")
@Component("com.example")
public class DmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmApplication.class, args);
    }

}
