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
@Table(name="Itens_Venda", uniqueConstraints = {@UniqueConstraint(columnNames = {"idItens"})})
public class ItensVenda {
	
		private Long idItens;
		@NotNull
		private Long idVenda;
		@NotNull
		private Long idProduto;
		@NotNull
		private int qtdItem;
		@NotNull
		private float vlrItem;
		
		public ItensVenda(){};
		
		public ItensVenda(Long idItens,Long idVenda, Long idProduto, int qtdItem, float vlrItem ) {
			this.idItens = idItens;
			this.idProduto = idProduto;
			this.idVenda = idVenda;
			this.qtdItem = qtdItem;
			this.vlrItem = vlrItem;
		}
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long getIdItens() {
			return idItens;
		}
		public void setIdItens(Long idItens) {
			this.idItens = idItens;
		}
		@Column(name = "idVenda", nullable = false)
		public Long getIdVenda() {
			return idVenda;
		}
		public void setIdVenda(Long idVenda) {
			this.idVenda = idVenda;
		}
		@Column(name = "idProduto", nullable = false)
		public Long getIdProduto() {
			return idProduto;
		}
		public void setIdProduto(Long idProduto) {
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
