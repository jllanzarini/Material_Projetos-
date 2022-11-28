package com.aula.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.aula.spring.modelo")
@ComponentScan(basePackages = "com.aula.spring")
public class SistemawebManhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemawebManhaApplication.class, args);
	}

}
