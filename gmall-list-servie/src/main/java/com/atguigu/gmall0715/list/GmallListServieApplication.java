package com.atguigu.gmall0715.list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.atguigu.gmall0715")
public class GmallListServieApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallListServieApplication.class, args);
    }

}
