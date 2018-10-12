package com.jstudio.bookstore.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

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
    /***
     * 文件上传根目录
     */
    @Value("${file.upload.path}")
    private String UploadRootPath;

}
