package com.example.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.modelo.Produtos;
@Repository
public interface ProdutoRepositorio  extends JpaRepository<Produtos, Long>{

}
