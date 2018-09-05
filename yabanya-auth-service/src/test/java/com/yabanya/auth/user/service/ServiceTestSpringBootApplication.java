package com.yabanya.auth.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.yabanya")
public class ServiceTestSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceTestSpringBootApplication.class, args);
    }
}
