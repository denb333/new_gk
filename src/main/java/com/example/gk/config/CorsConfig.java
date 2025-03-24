package com.example.gk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Cho phép tất cả API endpoint
                        .allowedOrigins("*") // Chấp nhận mọi domain (có thể thay bằng frontend cụ thể)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Các method HTTP được phép
                        .allowedHeaders("*") // Chấp nhận tất cả header
                        .allowCredentials(false); // Nếu có xác thực, bật `true`
            }
        };
    }
}
