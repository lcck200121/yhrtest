package com.example.mybatisps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.mybatisps.mapper")
@SpringBootApplication
public class MybatispsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatispsApplication.class, args);
    }

}
