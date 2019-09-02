package com.webClient.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.webClient.demo")
@PropertySource({"classpath:application.properties"})
public class DemoAppConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
