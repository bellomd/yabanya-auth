package com.yabanya.auth.orm.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.yabanya")
public class RepositoryTestSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepositoryTestSpringBootApplication.class, args);
    }
}
