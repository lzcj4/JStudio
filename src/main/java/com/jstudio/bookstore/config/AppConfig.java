package com.jstudio.bookstore.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Data
public class AppConfig {
    @Value("${spring.datasource.url}")
    private String ConnUrl;
    @Value("${spring.datasource.username}")
    private String User;
    @Value("${spring.datasource.password}")
    private String Password;
    @Value("${spring.datasource.driver-class-name}")
    private String DriverName;
}
