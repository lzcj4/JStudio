package com.jstudio.bookstore;

import com.alibaba.druid.pool.DruidDataSource;
import com.jstudio.bookstore.config.AppConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
@EnableConfigurationProperties({AppConfig.class})
@MapperScan(value = "com.jstudio.bookstore.mapper")
public class BookstoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext contxt = SpringApplication.run(BookstoreApplication.class, args);
        String s = "21";
//        Arrays.stream((new String[]{"1", "2"})).parallel().
    }

    @Autowired
    @Qualifier("appConfig")
    AppConfig config;

    @Bean(destroyMethod = "close")
    @Primary
    public DruidDataSource getDataSource() {
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

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
//        return new LanguageLocaleResolver();
    }
}
