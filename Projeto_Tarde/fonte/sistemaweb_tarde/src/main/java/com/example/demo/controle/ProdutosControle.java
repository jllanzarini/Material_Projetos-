package com.example.demo.controle;

import java.util.HashMap;
import java.util.Map;
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
import com.example.demo.modelo.Produtos;
import com.example.demo.repositorio.ProdutosRepositorio;

import jakarta.validation.Valid;



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
	    @GetMapping("/produtos/excluir/{id}")
		public String excluirPessoa(@PathVariable("id") long id) {
			Optional<Produtos> produtoOpt = produtosrepositorio.findById(id);
			if (produtoOpt.isEmpty()) {
				throw new IllegalArgumentException("Pessoa inválida.");
			}
			
			produtosrepositorio.delete(produtoOpt.get());
			return "redirect:/produtos";
		}
	    @GetMapping("/produtos/novo")
		 public String cadastrarProduto(Model model) {
				model.addAttribute("produtos", new Produtos(""));
				return "/cadastros/form_produto";
			}
	    @PostMapping("/produtos/salvar")
		 public String salvarProduto(@Valid @ModelAttribute("produtos") Produtos produtos,
				 BindingResult bindingResult, Model model) {
				
				produtosrepositorio.save(produtos);
				return "redirect:/produtos";
			}
	    @GetMapping("/produtos/alterar/{id}")
		public String alterarProduto(@PathVariable("id") long id, Model model) {
			Optional<Produtos> produtoOpt = produtosrepositorio.findById(id);
			if (!produtoOpt.isPresent()) {
				throw new IllegalArgumentException("Produto inválida.");
			}
			model.addAttribute("produtos", produtoOpt.get());
			return "/cadastros/form_produto";
		}
}
