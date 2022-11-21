package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.Carro;

@Repository

public interface CarroRepository extends JpaRepository<Carro, Integer>{

}
