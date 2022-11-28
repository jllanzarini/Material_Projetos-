package com.aula.spring.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name ="Produtos")
public class Produtos {
		private Long idProduto;
		@NotNull
		private String descricao;
		@NotNull	
		@NotNull
		private int qtd;
		@NotNull
		private double  vlrCompra;
		@NotNull
		private double  vlrVenda;
		@NotNull
		private String dtValidade;
		@NotNull
		private String fabricante;
		
		public Produtos(){
		
		}
		
		public Produtos(String descricao, int  qtd, Double vlrCompra, Double vlrVenda,
				String dtValidade, String fabricante){
			this.descricao =descricao;
			this.qtd = qtd;
			this.vlrCompra = vlrCompra;
			this.vlrVenda = vlrVenda;
			this.dtValidade = dtValidade;
			this.fabricante = fabricante;
		}
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
			public Long getId() {
			return idProduto;
		}
		public void setId(Long idProduto) {
			this.idProduto = idProduto;
		}

		@Column(name = "descricao", nullable = false)
		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String desc) {
			this.descricao = desc;
		}
		
		@Column(name = "Qtd", nullable = false)
		public int getQtd() {
			return qtd;
		}

		public void setQtd(int qtd) {
			this.qtd = qtd;
		}
		
		@Column(name = "vlrCompra", nullable = false)
		public double getVlrCompra() {
			return vlrCompra;
		}

		public void setVlrCompra(double vlrCompra) {
			this.vlrCompra = vlrCompra;
		}
		
		@Column(name = "vlrVenda", nullable = false)
		public double getVlrVenda() {
			return vlrVenda;
		}

		public void setVlrVenda(double vlrVenda) {
			this.vlrVenda = vlrVenda;
		}
		
		@Column(name = "dtValidade", nullable = false)
		public String getDtValidade() {
			return dtValidade;
		}

		public void setDtValidade(String dtValidade) {
			this.dtValidade = dtValidade;
		}
		
		@Column(name = "fabricante", nullable = false)
		public String getFabricante() {
			return fabricante;
		}

		public void setFabricante(String fabricante) {
			this.fabricante = fabricante;
		}
		
	
}
