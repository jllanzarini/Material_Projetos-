package com.projetofinal.sistemaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetofinal.sistemaweb.model.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>{

}
