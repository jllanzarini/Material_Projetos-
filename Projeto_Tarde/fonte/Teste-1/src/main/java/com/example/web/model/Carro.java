package com.example.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carros", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Carro {
	
	
	private int id;
	@NotNull
	private int ano;
	@NotNull
	private String cor;
	@NotNull
	private String marca;
	@NotNull
	private String modelo;
	
	
	public Carro() {
		
	}
	
	public Carro(int ano, String cor, String marca, String modelo) {
		this.ano = ano;
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "ano",nullable = false)
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	@Column(name = "cor",nullable = false)
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	@Column(name = "marca",nullable = false)
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Column(name = "modelo",nullable = false)
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
	
	
	
}
