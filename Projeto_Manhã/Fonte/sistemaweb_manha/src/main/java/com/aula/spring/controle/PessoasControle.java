package com.aula.spring.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.spring.modelo.Pessoas;
import com.aula.spring.repositorio.PessoasRepositorio;

import jakarta.validation.Valid;

@Controller
public class PessoasControle {
private PessoasRepositorio pessoasrepositorio;
	
	
	public PessoasControle(PessoasRepositorio pessoasrepositorio ) {
		this.pessoasrepositorio =pessoasrepositorio;
	}
	
	
	//Listagem das Pessoas Cadastradas
	@GetMapping("/pessoas")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas",pessoasrepositorio.findAll());
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
