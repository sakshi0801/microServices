package com.stackroute.springeurekaserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class SpringEurekaServeApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringEurekaServeApplication.class, args);
	}

}
