package com.tianjian.app1;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCasClient
@SpringBootApplication
public class CasApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(CasApp1Application.class, args);
    }
}
