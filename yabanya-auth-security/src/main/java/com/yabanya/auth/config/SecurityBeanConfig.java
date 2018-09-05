package com.yabanya.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class SecurityBeanConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new SecurityAuditorAware();
    }
}
