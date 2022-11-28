package com.example.projetoweb_m.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.projetoweb_m.modelo.Pessoas;
import com.example.projetoweb_m.repositorio.PessoaRepositorio;

import jakarta.validation.Valid;



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
	
	//Cadastrar Pessoa
	@GetMapping("/pessoas/nova")
	public String novaPessoa(Model model) {
		
		model.addAttribute("pessoas", new Pessoas());
		return "cadastros/novapessoa";

	}
	
	@PostMapping("pessoas/salvar")
	public String salvarPessoa(@Valid @ModelAttribute("pessoas") Pessoas pessoas, BindingResult bindingResult, Model model) {
			return "pessoas/novapessoa";
		
	}
}