package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long>{

}