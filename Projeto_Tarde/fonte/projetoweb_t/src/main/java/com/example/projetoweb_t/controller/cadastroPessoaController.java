package com.example.projetoweb_t.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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
import com.example.projetoweb_t.repository.cadastroPessoaRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class cadastroPessoaController {
	
	@Autowired
	private cadastroPessoaRepository cadastroPessoaRepository;
	
	//Pegar todos os cadastros
	@GetMapping("/cadastroPessoa")
	@ResponseStatus(HttpStatus.OK)
	public List<cadastroPessoa> getAllCadastro(){
		return this.cadastroPessoaRepository.findAll();
	}
	
	//Pegar cadastro pelo ID
	@GetMapping("/cadastroPessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<cadastroPessoa>getcadastroPessoaById(@PathVariable(value="id")int cadastroPessoaId)
	throws ResourceNotFoundException{
		cadastroPessoa cadPessoa = cadastroPessoaRepository.findById(cadastroPessoaId)
				.orElseThrow(() -> new ResourceNotFoundException("O ID "+cadastroPessoaId
						+ " não corresponde a nenhum Cadastro"));
		return ResponseEntity.ok().body(cadPessoa);
	}
	
	//Salvar Cadastro
	@PostMapping("cadastroPessoa")
	@ResponseStatus(HttpStatus.CREATED)
	public cadastroPessoa createCadastroPEssoa(@RequestBody cadastroPessoa cadastroPessoa) {
		return this.cadastroPessoaRepository.save(cadastroPessoa);
	}
	
	//Atualizar dados Pessoa
	@PutMapping("/cadastroPessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<cadastroPessoa> updateCadastroPessoa(@PathVariable(value="id")int cadastroPessoaId, 
			@Validated @RequestBody cadastroPessoa cadastroPessoaValores) throws ResourceNotFoundException{
		cadastroPessoa cadastroPessoa = cadastroPessoaRepository.findById(cadastroPessoaId)
			.orElseThrow(() -> new ResourceNotFoundException("O ID "+cadastroPessoaId
					+ " não corresponde a nenhum Cadastro"));
		cadastroPessoa.setNome(cadastroPessoaValores.getNome());
		cadastroPessoa.setEmail(cadastroPessoaValores.getEmail());
		cadastroPessoa.setTel(cadastroPessoaValores.getTel());
		cadastroPessoa.setSenha(cadastroPessoaValores.getSenha());
		
		return ResponseEntity.ok(this.cadastroPessoaRepository.save(cadastroPessoa));
	}
	
	//Deleletar Pessoa
	@DeleteMapping("/cadastroPessoa/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean>deletaCadastroPessoa(@PathVariable(value="id")int cadastroPessoaId) 
			throws ResourceNotFoundException{
		cadastroPessoa cadastroPessoa = cadastroPessoaRepository.findById(cadastroPessoaId)
				.orElseThrow(() -> new ResourceNotFoundException("O ID "+cadastroPessoaId
						+ " não corresponde a nenhum Cadastro"));
		this.cadastroPessoaRepository.delete(cadastroPessoa);
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("Cadastro deletado com sucesso", Boolean.TRUE);
		return resposta;
	}
	
}
