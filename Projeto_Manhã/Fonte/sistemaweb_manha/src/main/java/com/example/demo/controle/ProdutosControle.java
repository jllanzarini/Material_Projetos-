package com.example.demo.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Produtos;
import com.example.demo.repositorio.ProdutosRepositorio;

import jakarta.validation.Valid;

@Controller
public class ProdutosControle {
	
private ProdutosRepositorio produtosrepositorio;
	
	
	public ProdutosControle(ProdutosRepositorio produtosrepositorio ) {
		this.produtosrepositorio =produtosrepositorio;
	}
	//Listagem das Pessoas Cadastradas
		@GetMapping("/produtos")
		public String Produtos(Model model) {
			model.addAttribute("listaProdutos",produtosrepositorio.findAll());
			return "cadastros/lista_produtos";
		}
		
		
		//Cadastrar Produto
				@GetMapping("/produtos/novo")
				public String novoProduto(Model model) {
					
					model.addAttribute("produtos", new Produtos());
					return "cadastros/form_produto";

				}
				
				@PostMapping("/produtos/salvar")
				public String salvarProduto(@Valid @ModelAttribute("produtos") Produtos produto, BindingResult bindingResult, Model model) {
						return "cadastros/form_produto";
					
				}
			
}
