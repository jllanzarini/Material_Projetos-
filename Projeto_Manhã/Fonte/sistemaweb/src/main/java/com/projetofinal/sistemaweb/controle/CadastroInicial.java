package com.projetofinal.sistemaweb.controle;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetofinal.sistemaweb.model.Pessoa;
import com.projetofinal.sistemaweb.repository.PessoaRepository;

public class CadastroInicial {
	
	
	@Autowired
	private PessoaRepository pessoarepository;
	public void run(String ...args) throws Exception{
		Pessoa p1 =  new Pessoa();
		p1.setCpf("00000000000");
		p1.setNome("Admin");
		p1.setEmail("admin@suaempresa.com");
		p1.setDataNascimento(LocalDate.of(0000, 00, 00));
		p1.setSenha("admin");
		p1.setTelefone("00000");
		pessoarepository.save(p1);
		
	}
}
