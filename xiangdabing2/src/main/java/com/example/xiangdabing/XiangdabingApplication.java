package com.example.xiangdabing;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.xiangdabing.dao")
public class XiangdabingApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiangdabingApplication.class, args);
    }

}
