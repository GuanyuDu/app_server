package com.guanyu.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "union.benefit")
public class TestConfig {

    public Map<String, CouponPackageDetail> data;

    @Data
    static class CouponPackageDetail {

        private Long id;
        private Long couponPackageId;
        private String headImg;
        private List<String> benefits;
    }
}
