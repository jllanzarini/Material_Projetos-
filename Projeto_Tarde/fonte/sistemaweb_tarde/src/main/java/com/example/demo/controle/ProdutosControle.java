package com.example.demo.controle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.modelo.Produtos;
import com.example.demo.repositorio.ProdutosRepositorio;



@Controller
public class ProdutosControle {
	
private ProdutosRepositorio produtosrepositorio;
	
	
	public ProdutosControle(ProdutosRepositorio produtosrepositorio ) {
		this.produtosrepositorio =produtosrepositorio;
	}
	 @GetMapping("/produtos")
	  public String listar(ModelMap model) {
		  model.addAttribute("listaProdutos", produtosrepositorio.findAll());
		  return "/cadastros/lista_produtos";
	  }
	  
		@GetMapping("/produtos/novo")
		  public String cadastrar(@ModelAttribute("produtos") Produtos produtos) {
			  return "/cadastros/form_produto";
		  }
	  
	  @PostMapping("/produtos/salvar")
	  public String salvar(@ModelAttribute("produtos") Produtos produtos, RedirectAttributes attr) {
		  produtosrepositorio.save(produtos);
		  attr.addFlashAttribute("success", "Pessoa adicionada com sucesso");
		  return "redirect:/produtos";
	  }
	  
	  @GetMapping("/produtos/excluir/{id}")
		public String excluirPessoa(@PathVariable("id") long id) {
			Optional<Produtos> produtoOpt = produtosrepositorio.findById(id);
			if (produtoOpt.isEmpty()) {
				throw new IllegalArgumentException("Pessoa inválida.");
			}
			
			produtosrepositorio.delete(produtoOpt.get());
			return "redirect:/produtos";
		}
}
