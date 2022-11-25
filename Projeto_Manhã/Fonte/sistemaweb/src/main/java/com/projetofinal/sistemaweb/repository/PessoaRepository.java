package com.projetofinal.sistemaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.sistemaweb.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
