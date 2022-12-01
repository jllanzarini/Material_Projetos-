package com.example.demo.controle;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.modelo.Pessoas;
import com.example.demo.repositorio.PessoasRepositorio;


@Controller
public class PessoasControle {
private PessoasRepositorio pessoasrepositorio;
	
	
	public PessoasControle(PessoasRepositorio pessoasrepositorio ) {
		this.pessoasrepositorio =pessoasrepositorio;
	}
	
	@GetMapping("/")
	public String Inicial() {
		return "index";
	}
	//Lista todas as Pessoas cadastradas
	  @GetMapping("/pessoas")
	  public String listar(ModelMap model) {
		  model.addAttribute("listaPessoas", pessoasrepositorio.findAll());
		  return "/cadastros/lista_pessoas";
	  }
	  //instancia uma nova pessoa e chamar a tela form_pessoaa
	 @GetMapping("/pessoas/nova")
		  public String cadastrar(@ModelAttribute("pessoas") Pessoas pessoas) {
			  return "/cadastros/form_pessoa";//forwoard
		  }
	 //Guarda as informações no BD
	 @PostMapping("/pessoas/salvar")
	  public String salvar(@ModelAttribute("pessoas") Pessoas pessoas, RedirectAttributes attr) {
		  pessoasrepositorio.save(pessoas);
		  attr.addFlashAttribute("success", "Pessoa adicionada com sucesso");
		  return "redirect:/pessoas";//redirect
	  }
	 
	 //Excluir os registro de pessoas
	  @GetMapping("/pessoas/excluir/{id}")
		public String excluirPessoa(@PathVariable("id") long id) {
			Optional<Pessoas> pessoaOpt = pessoasrepositorio.findById(id);
			if (pessoaOpt.isEmpty()) {
				throw new IllegalArgumentException("Pessoa inválida.");
			}
		pessoasrepositorio.delete(pessoaOpt.get());
			return "redirect:/pessoas";
		}
	  
	  
	
}