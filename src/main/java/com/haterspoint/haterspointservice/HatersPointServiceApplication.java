package com.haterspoint.haterspointservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.haterspoint")
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages="com.haterspoint.entity")
@EnableJpaRepositories(basePackages="com.haterspoint.repository")
public class HatersPointServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(HatersPointServiceApplication.class, args);
	}

}
