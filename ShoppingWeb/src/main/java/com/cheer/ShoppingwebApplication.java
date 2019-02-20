package com.cheer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//扫描所有的dao层
@MapperScan("com.cheer.*.dao")
@SpringBootApplication
public class ShoppingwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingwebApplication.class, args);
    }

}

