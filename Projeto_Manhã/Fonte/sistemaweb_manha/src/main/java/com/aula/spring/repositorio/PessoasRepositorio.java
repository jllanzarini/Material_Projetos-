package com.aula.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.spring.modelo.Pessoas;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface PessoasRepositorio extends JpaRepository<Pessoas, Long>{

}
