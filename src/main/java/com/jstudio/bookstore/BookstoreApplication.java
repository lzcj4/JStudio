package com.jstudio.bookstore;

import com.alibaba.druid.pool.DruidDataSource;
import com.jstudio.bookstore.config.AppConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import sun.tools.java.Environment;

import javax.sql.DataSource;

@SpringBootApplication
@EnableConfigurationProperties({AppConfig.class})
@MapperScan("com.jstudio.bookstore.dao.mapper")
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Autowired
    AppConfig appConfig;

    @Bean(destroyMethod = "close")
    public DataSource getDataSoruce() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(appConfig.getConnUrl());
        dataSource.setUsername(appConfig.getUser());
        dataSource.setPassword(appConfig.getPassword());
        dataSource.setDriverClassName(appConfig.getDriverName());
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }
}
