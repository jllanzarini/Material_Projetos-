package com.aula.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.spring.modelo.Pessoas;

public interface PessoasRepositorio extends JpaRepository<Pessoas, Long>{

}
