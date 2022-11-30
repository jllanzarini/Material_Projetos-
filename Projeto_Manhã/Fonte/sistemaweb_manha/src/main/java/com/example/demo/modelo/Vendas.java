package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name= "Vendas", uniqueConstraints= {@UniqueConstraint(columnNames= {"idvenda"})})
public class Vendas {
	private Long idvenda;
	@NotNull
	private int idPessoa;
	@NotNull
	private int nroItens;
	@NotNull
	private Float vlrTotalVenda;
	
	public Vendas() {
		
	}
	public Vendas( int idPessoa, int nroItens, Float vlrTotalVenda) {
		this.idPessoa = idPessoa;
		this.nroItens = nroItens;
		this.vlrTotalVenda = vlrTotalVenda;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdvenda() {
		return idvenda;
	}
	public void setIdvenda(Long idvenda) {
		this.idvenda = idvenda;
	}
	
	@Column(name = "idPessoa", nullable = false)
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	@Column(name = "nroItens", nullable = false)
	public int getNroItens() {
		return nroItens;
	}
	public void setNroItens(int nroItens) {
		this.nroItens = nroItens;
	}
	
	@Column(name = "vlrTotalVenda", nullable = false)
	public Float getVlrTotalVenda() {
		return vlrTotalVenda;
	}
	public void setVlrTotalVenda(Float vlrTotalVenda) {
		this.vlrTotalVenda = vlrTotalVenda;
	}
	
	
	
}
