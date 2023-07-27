package com.guanyu.app.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Cache;
import com.guanyu.app.util.UserContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineConfiguration {

    @Bean
    public Cache<String, UserContext.UserInfo> userCache() {
        // 用户缓存在 24h 后清空，超过 1000 条后会清理老数据
        return Caffeine.newBuilder()
                .initialCapacity(128)
                .expireAfterWrite(24, TimeUnit.HOURS)
                .maximumSize(1000)
                .build();
    }
}
