package com.example.demo.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/pessoas/nova")
	public String cadastrar(@ModelAttribute("pessoas")Pessoas pessoas) {
		return "/cadastros/form_pessoa";
	}
	
	@PostMapping("/pessoas/salvar")
	public String salvar(@ModelAttribute("pessoas")Pessoas pessoas,RedirectAttributes attr) {
		pessoasrepositorio.save(pessoas);
		attr.addFlashAttribute("success", "Pessoa cadastrada com sucesso!");
		return "cadastros/lista_pessoa";
	}
	
	
	
	
}