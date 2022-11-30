package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Pessoas;

public interface PessoasRepositorio extends JpaRepository<Pessoas, Long> {

}
