package com.example.demo.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
		private Long id;
		@NotNull
		private String descricao;
		@NotNull	
		private int qtd;
		@NotNull
		private Float  vlrCompra;
		@NotNull
		private Float  vlrVenda;
		@NotNull
	    @JsonFormat(pattern="dd/MM/yyyy")
		private LocalDate dtValidade;
		@NotNull
		private String fabricante;
		
		public Produtos(){
		
		}
		
		public Produtos(String descricao){
			this.descricao =descricao;
		}
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
			public Long getId() {
			return id;
		}
		public void setId(Long idProduto) {
			this.id = idProduto;
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
		public Float getVlrCompra() {
			return vlrCompra;
		}

		public void setVlrCompra(Float vlrCompra) {
			this.vlrCompra = vlrCompra;
		}
		
		@Column(name = "vlrVenda", nullable = false)
		public Float getVlrVenda() {
			return vlrVenda;
		}

		public void setVlrVenda(Float vlrVenda) {
			this.vlrVenda = vlrVenda;
		}
		
		@Column(name = "dtValidade", nullable = false)
		public LocalDate getDtValidade() {
			return dtValidade;
		}

		public void setDtValidade(LocalDate dtValidade) {
			this.dtValidade = dtValidade;
		}
		
		@Column(name = "fabricante", nullable = false)
		public String getFabricante() {
			return fabricante;
		}

		public void setFabricante(String fabricante) {
			this.fabricante = fabricante;
		}
		@Override
		public String toString() {
			return "Produto [descricao=" + descricao + "]";
		}
}