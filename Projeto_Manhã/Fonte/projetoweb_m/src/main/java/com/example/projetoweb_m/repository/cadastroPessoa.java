package com.example.projetoweb_m.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cadastroPessoa extends JpaRepository<cadastroPessoa, Long> {
	
}
