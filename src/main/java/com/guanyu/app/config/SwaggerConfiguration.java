package com.guanyu.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "小程序 API 文档",
                description = "小程序后台相关接口",
                version = "1.0.0"
        ),
        servers = {
                @Server(description = "本地环境", url = "http://localhost/api/"),
                @Server(description = "线上环境", url = "https://dududu.top/api/")
        }
)
@Configuration
public class SwaggerConfiguration {

}
