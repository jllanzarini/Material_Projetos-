package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Vendas;
@Repository
public interface VendasReositorio extends JpaRepository<Vendas, Long> {

}
