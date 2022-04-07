package com.guanyu.app.config;

import com.guanyu.app.interceptor.LogInterceptor;
import com.guanyu.app.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Guanyu
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
    }
}
