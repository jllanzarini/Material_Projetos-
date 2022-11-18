package com.example.projetoweb_t.controller;

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

import com.example.projetoweb_t.exception.resourceNotFoundException;
import com.example.projetoweb_t.model.cadastroIntensVenda;
import com.example.projetoweb_t.repository.cadastroItensVendaRepository;

@RestController
@RequestMapping("/api/v1")
public class cadastroItensVendaController {
	@Autowired
	private cadastroItensVendaRepository cadastroitensvendarepository;
	
	//cadastrar Item da Venda
	@PostMapping("/cadastroItensVenda")
	@ResponseStatus(HttpStatus.CREATED)
	public cadastroIntensVenda cadastroitensvendarepository(@RequestBody cadastroIntensVenda cadastroitensvenda) {
		return this.cadastroitensvendarepository.save(cadastroitensvenda);
	}
	
	//buscar todos os intens
	@GetMapping("/cadastroItensVenda")
	@ResponseStatus(HttpStatus.OK)
	public List<cadastroIntensVenda>getAllItensVenda(){
		return this.cadastroitensvendarepository.findAll();
	}
	
	//Buscar item da Venda pelo seu ID
	@GetMapping("/cadastroItensVenda/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<cadastroIntensVenda>getAllItensVendaId(@PathVariable(value = "id")int cadastroItensVendaId)
		throws resourceNotFoundException{
		cadastroIntensVenda cadastroitensvenda = cadastroitensvendarepository.findById(cadastroItensVendaId)
				.orElseThrow(()-> new resourceNotFoundException("O id" + cadastroItensVendaId +
						"Não corrende a um Item da lista"));
				return ResponseEntity.ok().body(cadastroitensvenda);
	}
	//Atualizar item de uma venda
	@PutMapping("/cadastroItensVenda/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<cadastroIntensVenda>updateItensVenda(@PathVariable(value = "id")int cadastroItensVendaId,
			@Validated @RequestBody cadastroIntensVenda cadastroitensvenda) 
			throws resourceNotFoundException{
			cadastroIntensVenda cadastroitensVenda = cadastroitensvendarepository.findById(cadastroItensVendaId)
					.orElseThrow(()-> new resourceNotFoundException("O id" + cadastroItensVendaId +
							"Não corrende a um Item da lista"));
					cadastroitensVenda.setIdProduto(cadastroitensVenda.getIdProduto());
					cadastroitensVenda.setIdVenda(cadastroitensVenda.getIdVenda());
					cadastroitensVenda.setQtdItem(cadastroitensVenda.getQtdItem());
					cadastroitensVenda.setVlrItem(cadastroitensVenda.getVlrItem());
					
					return ResponseEntity.ok(this.cadastroitensvendarepository.save(cadastroitensVenda));
	}
	
	//Deleta item da vendaa
	@DeleteMapping("/cadastroItensVenda/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean>deletaItemVenda(@PathVariable(value = "id")int cadastroItensVendaId)
			throws resourceNotFoundException{
		cadastroIntensVenda cadastroitensVenda = cadastroitensvendarepository.findById(cadastroItensVendaId)
				.orElseThrow(()-> new resourceNotFoundException("O id" + cadastroItensVendaId +
						"Não corrende a um Item da lista"));
		this.cadastroitensvendarepository.delete(cadastroitensVenda);
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("Item Apagado com Sucesso!", Boolean.TRUE);
		return resposta;
	}
}
