package com.aiit.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.aiit.mapper")
@ComponentScan("com.aiit")
public class BaiduFaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaiduFaceApplication.class, args);
    }

}
