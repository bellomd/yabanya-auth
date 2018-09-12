package com.yabanya.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = AuthWebApplication.BASE_PACKAGES)
public class AuthWebApplication implements WebMvcConfigurer {

    static final String BASE_PACKAGES = "com.yabanya";

    public static void main(String[] args) {
        SpringApplication.run(AuthWebApplication.class, args);
    }
}
