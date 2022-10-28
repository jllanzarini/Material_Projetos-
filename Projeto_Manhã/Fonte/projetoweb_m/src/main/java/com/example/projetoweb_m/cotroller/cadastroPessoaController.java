package com.example.projetoweb_m.cotroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.example.projetoweb_m.repository.cadastroPessoaRepository;
import com.example.projetoweb_m.model.cadastroPessoa;

@RestController
@RequestMapping("/api/v1")
public class cadastroPessoaController {
	
	@Autowired
	private cadastroPessoaRepository cadastropessoaRepository;
	
	//Pegar todos os cadastros
	@GetMapping("/cadastroPessoa")
	@ResponseStatus(HttpStatus.OK)
	public List<cadastroPessoa> getAllCadastroPessoa(){
		return this.cadastropessoaRepository.findAll();
	}
	
	//Selecionar cadastro pelo ID
	@GetMapping("/cadastroPessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<cadastroPessoa>getcadastroPessoaById(@PathVariable(value="id")int cadastroPessoaId)
			throws ResourceNotFoundException{
				cadastroPessoa cadPessoa = cadastropessoaRepository.findById(cadastroPessoaId)
						.orElseThrow(() -> new ResourceNotFoundException("O ID "+cadastroPessoaId
								+ " não corresponde a nenhum Cadastro"));
				return ResponseEntity.ok().body(cadPessoa);
			}
	//Salvar Cadastro
		@PostMapping("cadastroPessoa")
		@ResponseStatus(HttpStatus.CREATED)
		public cadastroPessoa cadastropessoaRepository(@RequestBody cadastroPessoa cadastroPessoa) {
			return this.cadastropessoaRepository.save(cadastroPessoa);
		}
}	
	