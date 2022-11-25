package com.example.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.web.repositorio.PessoaRepositorio;

@Controller
public class PessoasController {
	
	@Autowired
	private PessoaRepositorio pessoarepository;
	
	//Listagem das Pessoas Cadastradas
	@GetMapping("/cadastro/pessoas")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas",pessoarepository.findAll());
		return "cadastros/pessoa";
	}

}
