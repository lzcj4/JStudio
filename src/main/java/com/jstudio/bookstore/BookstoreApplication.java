package com.jstudio.bookstore;

import com.alibaba.druid.pool.DruidDataSource;
import com.jstudio.bookstore.config.AppConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@EnableConfigurationProperties({AppConfig.class})
@MapperScan(value = "com.jstudio.bookstore.data")
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Autowired
    @Qualifier("appConfig")
    AppConfig config;

    @Bean(destroyMethod = "close")
    public DataSource getDataSoruce() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(config.getConnUrl());
        dataSource.setUsername(config.getUser());
        dataSource.setPassword(config.getPassword());
        dataSource.setDriverClassName(config.getDriverName());
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
