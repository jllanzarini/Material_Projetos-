package com.example.projetoweb_t.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoweb_t.model.cadastroPessoa;

@Repository //indica que a classe possui o papel de Data Access Object (DAO). Ela realiza operações de CRUD para a entidade que especificamos.
public interface cadastroPessoaRepository  extends JpaRepository<cadastroPessoa, Integer>{

}
