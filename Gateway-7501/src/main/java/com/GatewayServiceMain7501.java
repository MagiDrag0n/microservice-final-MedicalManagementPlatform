package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServiceMain7501 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceMain7501.class, args);
    }
}
