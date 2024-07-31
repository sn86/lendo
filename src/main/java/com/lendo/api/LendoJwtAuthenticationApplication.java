package com.lendo.api;

import com.lendo.api.service.IUserService;
import com.lendo.api.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LendoJwtAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(LendoJwtAuthenticationApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IUserService getUserService(){
        return new UserService();
    }

}
