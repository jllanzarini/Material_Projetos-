package com.example.demo.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.modelo.Vendas;
import com.example.demo.repositorio.VendasRepositorio;

@Controller
public class VendasControle {
	
private VendasRepositorio vendasrepositorio;
	
	
	public VendasControle(VendasRepositorio vendasrepositorio ) {
		this.vendasrepositorio =vendasrepositorio;
	}
		
	//Listagem das Pessoas Cadastradas
	@GetMapping("/vendas")
	public String pessoas(Model model) {
		model.addAttribute("listaVendas",vendasrepositorio.findAll());
		return "cadastros/lista_vendas";
	}
	
	//Cadastrar Pessoa
		@GetMapping("/vendas/nova")
		public String novaPessoa(Model model) {
			
			model.addAttribute("vendas", new Vendas());
			return "cadastros/form_vendas";

		}
}
