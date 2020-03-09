package com.example.currenyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.currenyconversionservice")
@EnableDiscoveryClient
public class CurrenyConversionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrenyConversionServiceApplication.class, args);
    }

}
