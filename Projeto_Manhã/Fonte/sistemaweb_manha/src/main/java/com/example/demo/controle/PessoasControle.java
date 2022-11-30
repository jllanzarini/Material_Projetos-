package com.example.demo.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Pessoas;
import com.example.demo.repositorio.PessoasRepositorio;

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
		return "cadastros/lista_pessoa";
	}
	
	//Cadastrar Pessoa
		@GetMapping("/pessoas/nova")
		public String novaPessoa(Model model) {
			
			model.addAttribute("pessoas", new Pessoas());
			return "cadastros/form_pessoa";

		}
		
		@PostMapping("/pessoas/salvar")
		public String salvarPessoa(@Valid @ModelAttribute("pessoas") Pessoas pessoas, BindingResult bindingResult, Model model) {
				return "pessoas/novapessoa";
			
		}
	
}