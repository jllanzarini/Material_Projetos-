package com.example.projetoweb_t;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.projetoweb_t.model"})
@EnableJpaRepositories(basePackages = {"com.example.projetoweb_t.repository"})
@ComponentScan(basePackages = {"com.example.projetoweb_t.controller"})
public class ProjetowebTApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetowebTApplication.class, args);
	}

}
