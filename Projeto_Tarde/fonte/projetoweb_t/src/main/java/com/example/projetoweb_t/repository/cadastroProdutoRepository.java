package com.example.projetoweb_t.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoweb_t.model.cadastroProduto;
@Repository
public interface cadastroProdutoRepository extends JpaRepository<cadastroProduto, Integer> {

}
