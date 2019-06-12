/**
 * This is main class for muzix service application
 */

package com.stackroute.muzixService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCaching
@EnableEurekaClient
public class MuzixService {

	public static void main(String[] args) {
		SpringApplication.run(MuzixService.class, args);
	}

}
