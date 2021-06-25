//package com.example.demo.Config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "com.lanre.datasource")
//    public DataSource DataSourceConfig(){
//
//        DataSourceBuilder<?> builder = DataSourceBuilder.create();
//        builder.username("root");
//        builder.password("rootuser");
//        builder.url("jdbc:mysql://localhost:3306/plant");
//
//        return builder.build();
//
//    }
// }
