package io.neca.infoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = {"io.neca.infoservice.repository"})
public class ProductInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductInfoServiceApplication.class, args);
	}
	
}
