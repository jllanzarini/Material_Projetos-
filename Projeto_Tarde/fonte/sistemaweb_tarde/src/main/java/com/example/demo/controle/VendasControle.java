package com.example.demo.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.modelo.Pessoas;
import com.example.demo.modelo.Produtos;
import com.example.demo.modelo.Vendas;
import com.example.demo.repositorio.PessoasRepositorio;
import com.example.demo.repositorio.ProdutosRepositorio;
import com.example.demo.repositorio.VendasRepositorio;


@Controller
public class VendasControle {
	@Autowired
	private ProdutosRepositorio produtosrepositorio;
	
	@Autowired
	private VendasRepositorio vendasrepositorio;
	
	@Autowired
	private PessoasRepositorio pessoasrepositorio;
	
		
	//Listagem das Pessoas Cadastradas
	@GetMapping("/vendas")
	public String pessoas(Model model) {
		model.addAttribute("listaVendas",vendasrepositorio.findAll());
		return "cadastros/lista_vendas";
	}
	
	
	
	  @GetMapping("vendas/nova")
	  public String cadastrar(@ModelAttribute("venda") Vendas venda) {
		  return "cadastros/form_venda";
	  }
	  
	  @PostMapping("vendas/salvar")
	  public String salvar(@ModelAttribute("venda") Vendas venda, RedirectAttributes attr) {
		  vendasrepositorio.save(venda);
		  attr.addFlashAttribute("success", "Produto adicionado com sucesso");
		  return "redirect:/vendas/cadastrar";
	  }

	  @ModelAttribute("pessoas")
	  public List<Pessoas> getClientes(){
		 return pessoasrepositorio.findAll();
	  }
	  
	  @ModelAttribute("produtos")
	  public List<Produtos> getProdutos(){
		 return produtosrepositorio.findAll();
	  }
}
