package com.example.forex.transaction.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ForexTransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexTransactionServiceApplication.class, args);
	}

}
