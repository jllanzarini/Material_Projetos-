package com.example.projetoweb_m.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projetoweb_m.modelo.Pessoas;


@Repository
public interface PessoaRepositorio  extends JpaRepository<Pessoas, Long>{

}
