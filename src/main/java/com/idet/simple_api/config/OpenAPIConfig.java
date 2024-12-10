package com.idet.simple_api.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {


    @Bean
    public OpenAPI configOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("IDET POS SYSTEM BACKEND")
                        .description("This document for create APIs for IDET POS System")
                        .version("2.0.0")
        );
    }
}
