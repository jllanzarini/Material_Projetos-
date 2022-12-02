package com.example.demo.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppControle {
	@GetMapping("/")
	public String Inicial() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
