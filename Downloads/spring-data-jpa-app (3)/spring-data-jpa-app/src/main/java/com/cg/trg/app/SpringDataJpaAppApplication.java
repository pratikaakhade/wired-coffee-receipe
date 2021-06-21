package com.cg.trg.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cg.trg")
@EntityScan(basePackages = "com.cg.trg.entity")
@EnableJpaRepositories(basePackages = "com.cg.trg.dao")
public class SpringDataJpaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaAppApplication.class, args);
	}

}
