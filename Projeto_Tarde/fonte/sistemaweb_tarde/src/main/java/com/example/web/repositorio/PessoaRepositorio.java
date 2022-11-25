package com.example.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.modelo.Pessoas;
@Repository
public interface PessoaRepositorio  extends JpaRepository<Pessoas, Long>{

}
