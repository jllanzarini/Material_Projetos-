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
import com.example.projetoweb_m.model.cadastroVendas;
import com.example.projetoweb_m.repository.cadastroVendasRepository;

@RestController
@RequestMapping("/api/v1")
public class cadastroVendaController {
	@Autowired
	private cadastroVendasRepository cadastroVendasrepository;
	
	//Cadastrar venda
	@PostMapping("/CadastroVendas")
	@ResponseStatus(HttpStatus.CREATED)
	public cadastroVendas cadastroVendasRepository(@RequestBody cadastroVendas cadastrovendas) {
		return this.cadastroVendasrepository.save(cadastrovendas);
	}
	
	//Pegar todas as vendas
	@GetMapping("/CadastroVendas")
	@ResponseStatus(HttpStatus.OK)
	public List<cadastroVendas> getAllCadastroVendas(){
		return this.cadastroVendasrepository.findAll();
	}
	
	//Consultar cadastro pelo ID
	@GetMapping("/CadastroVendas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<cadastroVendas>getCadastroVendasById(@PathVariable(value="id")Integer cadastroVendasId)
			throws resourceNotFoundException{
		cadastroVendas cadastroVendas = cadastroVendasrepository.findById(cadastroVendasId)
						.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroVendasId
								+ " não corresponde a nenhum Cadastro"));
				return ResponseEntity.ok().body(cadastroVendas);
			}
		
		
	//Atualizar cadastro Vendas
	@PutMapping("/CadastroVendas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<cadastroVendas> updateCadastroVendas(@PathVariable(value="id")Integer cadastroVendasId, 
		@Validated @RequestBody cadastroVendas cadastroVendasValores) throws resourceNotFoundException{
		cadastroVendas cadastroVendas = cadastroVendasrepository.findById(cadastroVendasId)
				.orElseThrow(() -> new resourceNotFoundException("O ID "+ cadastroVendasId
						+ " não corresponde a nenhum Cadastro"));
		cadastroVendas.setIdPessoa(cadastroVendasValores.getIdPessoa());
		cadastroVendas.setNroItens(cadastroVendasValores.getNroItens());
		cadastroVendas.setValorTotalVenda(cadastroVendasValores.getValorTotalVenda());
		
		return ResponseEntity.ok(this.cadastroVendasrepository.save(cadastroVendas));
	}
	
	//Deletar Venda
	@DeleteMapping("/CadastroVendas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean>deletaCadastroVendas(@PathVariable(value="id")Integer cadastroVendasId) 
			throws resourceNotFoundException{
		cadastroVendas cadastroVendas = cadastroVendasrepository.findById(cadastroVendasId)
				.orElseThrow(() -> new resourceNotFoundException("O ID "+cadastroVendasId
						+ " não corresponde a nenhum Cadastro"));
		this.cadastroVendasrepository.delete(cadastroVendas);
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("Cadastro deletado com sucesso", Boolean.TRUE);
		return resposta;
	}

}
