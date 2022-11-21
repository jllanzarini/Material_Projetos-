package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.web.model.cadastroProduto;
import com.example.web.repository.cadastroProdutoRepository;


@Controller
public class cadastroProdutoController {
	@Autowired
	private cadastroProdutoRepository cadastroprodutorepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastroproduto")
	public String inicio() {
		return "cadastro/cadastroproduto";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/salvarproduto")
	public String SalvarProduto(cadastroProduto cadastroproduto) {
		cadastroprodutorepository.save(cadastroproduto);
		return "cadastro/cadastroproduto";
	}
}
