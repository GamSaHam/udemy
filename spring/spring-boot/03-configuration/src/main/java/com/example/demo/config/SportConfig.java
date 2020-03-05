package com.example.demo.config;

import com.example.demo.dto.Coach;
import com.example.demo.dto.SwimCoach;
import com.example.demo.services.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.demo.dto")
@PropertySource("classpath:sport.properties")
public class SportConfig {


    @Bean
    public FortuneService fortuneService(){
        return new FortuneService();
    }


    @Bean
    public Coach swimCoach(){

        return new SwimCoach(fortuneService());

    }

}
