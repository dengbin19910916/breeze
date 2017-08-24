package com.geek.breeze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BreezeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreezeApplication.class, args);
	}
}
