package com.example.projetoweb_m.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "Vendas", uniqueConstraints= {@UniqueConstraint(columnNames= {"idVenda"})})
public class cadastroVendas {
	private int idVenda;
	@NotNull
	private int idPessoa;
	@NotNull
	private int nroItens;
	@NotNull
	private float valorTotalVenda;
	
	public cadastroVendas() {
	}
	
	public cadastroVendas(int idPessoa, int nroItens, float valorTotalVenda) {
		this.idPessoa = idPessoa;
		this.nroItens = nroItens;
		this.valorTotalVenda = valorTotalVenda;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	@Column(name="idPessoa", nullable = false)
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	@Column(name="nroItens", nullable = false)
	public int getNroItens() {
		return nroItens;
	}
	public void setNroItens(int nroItens) {
		this.nroItens = nroItens;
	}
	
	@Column(name="valorTotalVenda", nullable = false)
	public float getValorTotalVenda() {
		return valorTotalVenda;
	}
	public void setValorTotalVenda(float valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}
	
}