package com.geek.apply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplyApplication.class, args);
	}
}
