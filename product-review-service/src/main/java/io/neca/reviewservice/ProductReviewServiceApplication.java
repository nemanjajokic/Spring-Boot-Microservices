package io.neca.reviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductReviewServiceApplication.class, args);
	}

}
