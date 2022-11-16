package com.example.projetoweb_m.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoweb_m.exception.resourceNotFoundException;
import com.example.projetoweb_m.model.cadastroProduto;
import com.example.projetoweb_m.repository.cadastroProdutoRepository;

@RestController
@RequestMapping("/api/v1")
public class cadastroProdutoController {
	@Autowired
	private cadastroProdutoRepository cadastroprodutoRepository;
	
	//Pegar todos os produtos cadastrados
	@GetMapping("/cadastroProduto")
	@ResponseStatus(HttpStatus.OK)
	public List<cadastroProduto>getAllCadastroProdutos(){
		return this.cadastroprodutoRepository.findAll();
	}
	
	//Selecionar Produto pelo ID
	@GetMapping("/cadastroProduto/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<cadastroProduto>getAllCadastroProdutos(@PathVariable(value="id")int cadastroProdutoId)
			throws resourceNotFoundException{
		cadastroProduto cadastroProduto = cadastroprodutoRepository.findById(cadastroProdutoId)
				.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroProdutoId
						+ " não corresponde a nenhum Cadastro"));
		return ResponseEntity.ok().body(cadastroProduto);
	}
	@PostMapping("/cadastroProduto")
	@ResponseStatus(HttpStatus.CREATED)
	public cadastroProduto cadastroProdutoRepository(@RequestBody cadastroProduto cadastroProduto) {
		return this.cadastroprodutoRepository.save(cadastroProduto);
	}
	
	//Atualizar cadastro Produto
	@PutMapping("/cadastroProduto/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<cadastroProduto> updateCadastroProduto(@PathVariable(value="id")int cadastroProdutoId, 
		@Validated @RequestBody cadastroProduto cadastroProdutoValores) throws resourceNotFoundException{
		cadastroProduto cadastroProduto = cadastroprodutoRepository.findById(cadastroProdutoId)
				.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroProdutoId
						+ " não corresponde a nenhum Cadastro"));
		
			cadastroProduto.setDescricao(cadastroProdutoValores.getDescricao());
			cadastroProduto.setQtd(cadastroProdutoValores.getQtd());
			cadastroProduto.setVlrCompra(cadastroProdutoValores.getVlrCompra());
			cadastroProduto.setVlrVenda(cadastroProdutoValores.getVlrVenda());
			cadastroProduto.setDtValidade(cadastroProdutoValores.getDtValidade());
			cadastroProduto.setFabricante(cadastroProdutoValores.getFabricante());		
			
			return ResponseEntity.ok(this.cadastroprodutoRepository.save(cadastroProduto));
	}
	
	//Deleletar Produto
	@DeleteMapping("/cadastroProduto/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean>deletaCadastroProduto(@PathVariable(value="id")int cadastroProdutoId) 
			throws resourceNotFoundException{
		cadastroProduto cadastroProduto = cadastroprodutoRepository.findById(cadastroProdutoId)
				.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroProdutoId
						+ " não corresponde a nenhum Cadastro"));
		this.cadastroprodutoRepository.delete(cadastroProduto);
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("Cadastro deletado com sucesso", Boolean.TRUE);
		return resposta;
	}

}
