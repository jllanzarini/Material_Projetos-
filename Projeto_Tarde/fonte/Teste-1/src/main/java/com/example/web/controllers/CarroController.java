package com.example.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.web.model.Carro;
import com.example.web.repository.CarroRepository;






@Controller
public class CarroController {
	
	@Autowired
	private CarroRepository carrorepository;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastrocarro")
	public String inicio() {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/salvarcarro")
	public String salvarCarro(Carro carro) {
		carrorepository.save(carro);
		return "index";
	}
    
}
