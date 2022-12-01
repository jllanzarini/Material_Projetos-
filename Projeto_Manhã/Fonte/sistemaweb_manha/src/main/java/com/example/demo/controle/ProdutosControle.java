package com.example.demo.controle;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.modelo.Produtos;
import com.example.demo.repositorio.ProdutosRepositorio;

import jakarta.validation.Valid;

@Controller
public class ProdutosControle {
	
private ProdutosRepositorio produtosrepositorio;
	
	
	public ProdutosControle(ProdutosRepositorio produtosrepositorio ) {
		this.produtosrepositorio =produtosrepositorio;
	}
	//Listagem das produtos Cadastrados
		@GetMapping("/produtos")
		public String Produtos(Model model) {
			model.addAttribute("listaProdutos",produtosrepositorio.findAll());
			return "cadastros/lista_produtos";
		}
	@GetMapping("/produtos/novo")
	public String cadastrarProduto(@ModelAttribute("produtos")Produtos produtos) {
		return "/cadastros/form_produto";
	}
	
	@PostMapping("/produtos/salvar")
	public String salvarProduto(@ModelAttribute("produtos") Produtos produtos, RedirectAttributes attr ) {
		produtosrepositorio.save(produtos);
		attr.addFlashAttribute("Success", "Produto Cadastrado!");
		return "redirect:/produtos";		
	}
	
	@GetMapping("/produtos/excluir/{id}")
	public String excluirProduto(@PathVariable("id") long id) {
		Optional<Produtos> produtoOpt = produtosrepositorio.findById(id);
		if (produtoOpt.isEmpty()) {
			throw new IllegalArgumentException("Produto inválida.");
		}
		
		produtosrepositorio.delete(produtoOpt.get());
		return "redirect:/produtos";
	}
}
