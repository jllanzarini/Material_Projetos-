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
@Table(name = "Itens_Venda", uniqueConstraints = {@UniqueConstraint(columnNames = {"idItens"})})
public class cadastroIntensVenda {
	
	private int idItens;
	@NotNull
	private int idVenda;
	@NotNull
	private int idProduto;
	@NotNull
	private int qtdItem;
	@NotNull
	private float vlrItem;
	
	public cadastroIntensVenda() {
		
	}
	
	public cadastroIntensVenda(int idItens, int idVenda, int idProduto, int qtdItem, float vlrItem) {
		this.idItens = idItens;
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.qtdItem = qtdItem;
		this.vlrItem = vlrItem;
		
	}
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getIdItens() {
			return idItens;
		}
	
		public void setIdItens(int idItens) {
			this.idItens = idItens;
		}

		@Column(name = "idVenda", nullable = false)
		public int getIdVenda() {
				return idVenda;
			}
	
		
		public void setIdVenda(int idVenda) {
			this.idVenda = idVenda;
		}
	
		@Column(name = "idProduto", nullable = false)
		public int getIdProduto() {
			return idProduto;
		}
	
		public void setIdProduto(int idProduto) {
			this.idProduto = idProduto;
		}
	
		@Column(name = "qtdItem", nullable = false)
		public int getQtdItem() {
			return qtdItem;
		}
	
		public void setQtdItem(int qtdItem) {
			this.qtdItem = qtdItem;
		}
	
		@Column(name = "vlrItem", nullable = false)
		public float getVlrItem() {
			return vlrItem;
		}
	
		public void setVlrItem(float vlrItem) {
			this.vlrItem = vlrItem;
		}
	
	
	
	
	
}
