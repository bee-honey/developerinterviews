package com.nakeer.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LocalProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalProductServiceApplication.class, args);
	}

}
