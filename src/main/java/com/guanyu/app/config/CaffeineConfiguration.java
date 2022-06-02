package com.guanyu.app.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaffeineConfiguration {

    @Bean
    public Cache<String, String> userCache() {
        return Caffeine.newBuilder().maximumSize(1000).build();
    }
}
