package com.example.demo.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repositorio.ItensVendaRepositorio;

@Controller
public class ItensVendaControle {
private ItensVendaRepositorio intensvendaresositorio;
	
	
	public ItensVendaControle(ItensVendaRepositorio intensvendaresositorio ) {
		this.intensvendaresositorio =intensvendaresositorio;
	}
	
		
	//Listagem das Pessoas Cadastradas
	@GetMapping("/itensvenda")
	public String pessoas(Model model) {
		model.addAttribute("listaItens",intensvendaresositorio.findAll());
		return "cadastros/lista_venda";
	}
}
