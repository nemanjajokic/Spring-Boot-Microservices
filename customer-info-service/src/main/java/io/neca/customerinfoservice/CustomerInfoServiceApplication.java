package io.neca.customerinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerInfoServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerInfoServiceApplication.class, args);
	}

}
