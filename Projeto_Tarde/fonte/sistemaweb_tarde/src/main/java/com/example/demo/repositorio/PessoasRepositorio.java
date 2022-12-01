package com.example.demo.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modelo.Pessoas;


@Repository
public interface PessoasRepositorio extends JpaRepository<Pessoas, Long> {
}
