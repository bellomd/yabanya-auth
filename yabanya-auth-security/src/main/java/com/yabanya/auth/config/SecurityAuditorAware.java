package com.yabanya.auth.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SecurityAuditorAware implements AuditorAware<String> {

    private static final String DEFAULT_CREATED_BY = "SYSTEM";

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(DEFAULT_CREATED_BY);
    }
}
