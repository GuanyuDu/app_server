package com.guanyu.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redis configuration
 *
 * @author Guanyu
 */
//@Configuration
public class RedisConfiguration {

    @Value("${spring.redis.host}")
    private String hostName;
    @Value("${spring.redis.port}")
    private int port;

//    @Bean
//    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
//        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//        configuration.setHostName(hostName);
//        configuration.setPort(port);
//        configuration.setDatabase(0);
//        return configuration;
//    }
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(RedisStandaloneConfiguration redisStandaloneConfiguration) {
//        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration);
//        factory.setValidateConnection(true);
//        return factory;
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
//        return redisTemplate;
//    }
}
