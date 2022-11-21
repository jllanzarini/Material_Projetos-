package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.example.web.model")
@ComponentScan(basePackages = {"com.example.web.*"})
public class Teste1Application {

	public static void main(String[] args) {
		SpringApplication.run(Teste1Application.class, args);
	}

}
