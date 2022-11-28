package com.aula.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.spring.modelo.Produtos;

public interface ProdutosRepositorio extends JpaRepository<Produtos, Long> {

}
