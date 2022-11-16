package com.example.projetoweb_m.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoweb_m.model.cadastroIntensVenda;


@Repository
public interface cadastroItensVendaRepository extends JpaRepository<cadastroIntensVenda, Integer> {

}
