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
@Table(name ="pessoas", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class cadastroPessoa {
	private int id;
	@NotNull
	
	@Size(min=2, max=100)
	private String nome;
	
	@NotNull
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
	
	@Column(name="email", nullable=false, unique=true)
	public String getEmail() {
		return email;
	}
	@Column(name="tel", nullable=false, unique=true)
	public String getTel() {
		return tel;
	}
	@Column(name="senha", nullable=false, unique=true)
	public String getSenha() {
		return senha;
	}
	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", Nome=" + nome + ",E-mail=" + email+", "
				+ "Telefone="+tel+", Senha="+senha+"]";
	}
	
}
