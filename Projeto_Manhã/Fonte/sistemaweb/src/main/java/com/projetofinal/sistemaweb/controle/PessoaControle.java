package com.projetofinal.sistemaweb.controle;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projetofinal.sistemaweb.repository.PessoaRepository;

@Controller
public class PessoaControle {
	
	@Autowired
	private PessoaRepository pessoarepository;

	//Listagem das Pessoas Cadastradas
	@GetMapping("/cadastro/pessoas")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas",pessoarepository.findAll());
		return "cadastros/pessoa";
	}
		
				
}	
	