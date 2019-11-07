package com.tianjian.app2;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCasClient
@SpringBootApplication
public class CasApp2Application {

    public static void main(String[] args) {
        SpringApplication.run(CasApp2Application.class, args);
    }
}
