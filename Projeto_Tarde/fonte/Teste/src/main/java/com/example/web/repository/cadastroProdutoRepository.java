package com.example.web.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.cadastroProduto;


@Repository
@Transactional
public interface cadastroProdutoRepository extends JpaRepository<cadastroProduto, Integer> {

}
