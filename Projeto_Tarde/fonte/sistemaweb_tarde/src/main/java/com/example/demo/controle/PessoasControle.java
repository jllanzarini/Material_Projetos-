package com.example.demo.controle;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	//Lista todas as Pessoas cadastradas
	  @GetMapping("/pessoas")
	  public String listar(ModelMap model) {
		  model.addAttribute("listaPessoas", pessoasrepositorio.findAll());
		  return "/cadastros/lista_pessoas";
	  }
	  //instancia uma nova pessoa e chamar a tela form_pessoaa
	 @GetMapping("/pessoas/nova")
	 public String cadastrar(Model model) {
			model.addAttribute("pessoas", new Pessoas(""));
			return "/cadastros/form_pessoa";
		}
	 //Guarda as informações no BD
	 @PostMapping("/pessoas/salvar")
	 public String salvarPessoa(@Valid @ModelAttribute("pessoas") Pessoas pessoas,
			 BindingResult bindingResult, Model model) {
			
			pessoasrepositorio.save(pessoas);
			return "redirect:/pessoas";
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
	  @GetMapping("/pessoas/alterar/{id}")
		public String alterarPessoa(@PathVariable("id") long id, Model model) {
			Optional<Pessoas> pessoaOpt = pessoasrepositorio.findById(id);
			if (!pessoaOpt.isPresent()) {
				throw new IllegalArgumentException("Pessoa inválida.");
			}
			model.addAttribute("pessoas", pessoaOpt.get());
			return "/cadastros/form_pessoa";
		}
}