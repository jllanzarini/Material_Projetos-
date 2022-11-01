package com.example.projetoweb_m.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name ="clientes", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class cadastroPessoa {
	private int id;
	@NotNull
	private String nome;
	@NotNull
	@Size(min =2, max= 100)
	@Email
	@Pattern(regexp=".+@.+\\..+", message = "Informe um e-mail válido")
	private String email;
	@NotNull
	private String tel;
	@NotNull
	private String senha;
		
	public cadastroPessoa() {
		
	}
	
	public cadastroPessoa(String nome, String email, String tel, String senha) {
		this.nome = nome;
		this.email = email;
		this.tel = tel;
		this.senha = senha;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "NOME", nullable = false)
	public String getNome() {
			return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;

	}
	
	@Column(name = "EMAIL", nullable = false, unique = true)
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;

		}
	@Column(name = "TEL", nullable = false)
	
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;

	}
	@Column(name = "SENHA", nullable = false)
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
	
		}
	@Override
	public String toString() {
		return "Pessoa [id= "+id+", Nome= "+ nome + ", E-mail= "+ email + ", Telefone= "+ tel +
				", Senha= "+ senha + "]";
	}
}
