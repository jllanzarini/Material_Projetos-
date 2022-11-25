package com.example.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.web.repositorio.PessoaRepositorio;



@Controller
public class PessoasController {
	
	private PessoaRepositorio pessoarepositorio;
	
	
	public PessoasController(PessoaRepositorio pessoarepositorio ) {
		this.pessoarepositorio =pessoarepositorio;
	}
	
	
	//Listagem das Pessoas Cadastradas
	@GetMapping("/pessoas")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas",pessoarepositorio.findAll());
		return "cadastros/pessoa";
	}
}
