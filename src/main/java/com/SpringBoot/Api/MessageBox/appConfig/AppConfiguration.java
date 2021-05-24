package com.SpringBoot.Api.MessageBox.appConfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Data
public class AppConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testeAppConfiguration(){
        System.out.println("DB connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB connection to H2";
    }

    @Profile("prod")
    @Bean
    public String prodAppConfiguration(){
        System.out.println("DB connection for PROD");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB connection to POSTGRESQL";
    }

    @Profile("test")
    @Bean
    public String testAppConfiguration(){
        System.out.println("DB connection for TEST");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB connection to POSTGRESQL in TESTER";
    }

}
