package com.example.projetoweb_m.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoweb_m.exception.resourceNotFoundException;
import com.example.projetoweb_m.model.cadastroIntensVenda;
import com.example.projetoweb_m.model.cadastroProduto;
import com.example.projetoweb_m.repository.cadastroItensVendaRepository;

@RestController
@RequestMapping("/api/v1")
public class cadastroItensVendaController {
	
	@Autowired
	private cadastroItensVendaRepository cadastroitensvendarepository;
	
	
	//Cadastra os itens
	@PostMapping("/cadastroItensVenda")
	@ResponseStatus(HttpStatus.CREATED)
	public cadastroIntensVenda cadastroitensvendarepository(@RequestBody cadastroIntensVenda cadastroitensvenda) {
		return this.cadastroitensvendarepository.save(cadastroitensvenda);
	}
	
	//Buscar todos os itens
	@GetMapping("/cadastroItensVenda")
	@ResponseStatus(HttpStatus.OK)
	public List<cadastroIntensVenda>getAllitensVenda(){
		return this.cadastroitensvendarepository.findAll();
	}
	//Selecionar Produto pelo ID
		@GetMapping("/cadastroItensVenda/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<cadastroIntensVenda>getAllItensVEndaId(@PathVariable(value="id")int cadastroIntensVendaId)
				throws resourceNotFoundException{
			cadastroIntensVenda cadastroitensvenda = cadastroitensvendarepository.findById(cadastroIntensVendaId)
					.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroIntensVendaId
							+ " não corresponde a nenhum Cadastro"));
			return ResponseEntity.ok().body(cadastroitensvenda);
		}

}
