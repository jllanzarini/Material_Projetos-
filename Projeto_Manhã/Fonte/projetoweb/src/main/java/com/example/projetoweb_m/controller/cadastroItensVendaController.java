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
import com.example.projetoweb_m.model.cadastroIntensVenda;
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
		
		//Atualizar item da venda
		@PutMapping("/cadastroItensVenda/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<cadastroIntensVenda> updateitemVenda(@PathVariable(value="id")int cadastroIntensVendaId, 
				@Validated @RequestBody cadastroIntensVenda cadastrointensvenda) throws resourceNotFoundException{
			cadastroIntensVenda cadastrointensVenda = cadastroitensvendarepository.findById(cadastroIntensVendaId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroIntensVendaId
								+ " não corresponde a nenhum Cadastro"));
				
					cadastrointensVenda.setIdProduto(cadastrointensVenda.getIdProduto());
					cadastrointensVenda.setIdVenda(cadastrointensVenda.getIdVenda());
					cadastrointensVenda.setQtdItem(cadastrointensVenda.getQtdItem());
					cadastrointensVenda.setVlrItem(cadastrointensVenda.getVlrItem());
							
					
					return ResponseEntity.ok(this.cadastroitensvendarepository.save(cadastrointensVenda));
			}
		//Deleletar Item da venda
		@DeleteMapping("/cadastroItensVenda/{id}")
		@ResponseStatus(HttpStatus.OK)
		public Map<String, Boolean>deletacadastroItensVenda(@PathVariable(value="id")int cadastroIntensVendaId) 
				throws resourceNotFoundException{
			cadastroIntensVenda cadastrointensVenda = cadastroitensvendarepository.findById(cadastroIntensVendaId)
					.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroIntensVendaId
							+ " não corresponde a nenhum Cadastro"));
			this.cadastroitensvendarepository.delete(cadastrointensVenda);
			Map<String, Boolean> resposta = new HashMap<>();
			resposta.put("Cadastro deletado com sucesso", Boolean.TRUE);
			return resposta;
		}
}
