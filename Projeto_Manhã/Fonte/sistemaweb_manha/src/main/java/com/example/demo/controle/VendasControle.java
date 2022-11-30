package com.example.demo.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repositorio.VendasReositorio;

@Controller
public class VendasControle {
	private VendasReositorio vendasrepositorio;
	
	public VendasControle(VendasReositorio vendasrepositorio ) {
		this.vendasrepositorio =vendasrepositorio;
	}
	
	//Listagem das Vendas Cadastradas
		@GetMapping("/vendas")
		public String ListaVendas(Model model) {
			model.addAttribute("listaVendas",vendasrepositorio.findAll());
			return "cadastros/lista_vendas";
		}
}
