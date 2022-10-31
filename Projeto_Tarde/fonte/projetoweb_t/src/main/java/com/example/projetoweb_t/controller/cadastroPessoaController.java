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

import com.example.projetoweb_t.model.cadastroPessoa;
import com.example.projetoweb_t.exception.*;
import com.example.projetoweb_t.repository.cadastroPessoaRepository;
@RestController
@RequestMapping("/api/v1")
public class cadastroPessoaController {
	
	@Autowired
	private cadastroPessoaRepository cadastroRepository;
	
	//pegar todas as contas
	@GetMapping("/cadastrosPessoa")
	@ResponseStatus(HttpStatus.OK)
	public List<cadastroPessoa> getAllCadastros(){
		
		return this.cadastroRepository.findAll();
		
	}
	
	//pegar a conta pelo id
	@GetMapping("/cadastrosPessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<cadastroPessoa> getCadastroById(@PathVariable(value = "id") Long cadastroPessoaid)
	    throws resourceNotFoundException {
		
		cadastroPessoa cadastroPessoa = cadastroRepository.findById(cadastroPessoaid)
	      .orElseThrow(() -> new resourceNotFoundException("Conta não encontrada para o ID :: " + cadastroPessoaid));
	    return ResponseEntity.ok().body(cadastroPessoa);
	    
	}
	
	//salvar conta
	@PostMapping("/cadastrosPessoa")
	@ResponseStatus(HttpStatus.CREATED)
	public cadastroPessoa createCadastro(@RequestBody cadastroPessoa cadastro) {
		
		return this.cadastroRepository.save(cadastro);
		
	}
	
	//atualizar conta
	@PutMapping("/cadastrosPessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<cadastroPessoa> updateCadastro(@PathVariable(value = "id") Long cadastroPessoaId,
    	@Validated @RequestBody cadastroPessoa cadastroCaracteristicas) throws resourceNotFoundException {
    	cadastroPessoa cadastroPessoa = cadastroRepository.findById(cadastroPessoaId)
        .orElseThrow(() -> new resourceNotFoundException("Conta não encontrada para o ID : " + cadastroPessoaId));
        
    	cadastroPessoa.setCpf(cadastroCaracteristicas.getCpf());
    	cadastroPessoa.setEmail(cadastroCaracteristicas.getEmail());
    	cadastroPessoa.setNome(cadastroCaracteristicas.getNome());
    	cadastroPessoa.setDataNascimento(cadastroCaracteristicas.getDataNascimento());
    	cadastroPessoa.setSenha(cadastroCaracteristicas.getSenha());
    	cadastroPessoa.setTelefone(cadastroCaracteristicas.getTelefone());
    	
        
        return ResponseEntity.ok(this.cadastroRepository.save(cadastroPessoa));
        
    }
	
	//deletar conta
	@DeleteMapping("/cadastrosPessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean> deleteCadastro(@PathVariable(value = "id") Long cadastroPessoaId) 
			throws resourceNotFoundException {
		cadastroPessoa cadastroPessoa = cadastroRepository.findById(cadastroPessoaId)
	   .orElseThrow(() -> new resourceNotFoundException("Conta não encontrada para o ID :: " + cadastroPessoaId));
	
	    this.cadastroRepository.delete(cadastroPessoa);
	    Map<String, Boolean> resposta = new HashMap<>();
	    resposta.put("cadastro deletado", Boolean.TRUE);
	    return resposta;
	}

}