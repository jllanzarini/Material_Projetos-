package com.example.projetoweb_m.modelo;

import java.time.LocalDate;






import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Pessoas", uniqueConstraints = {@UniqueConstraint(columnNames = {"CPF","email"})})
public class Pessoas {
	private long id;
    @NotNull
    @Pattern(regexp="\\d{11}", message = "Apenas informe 11 digitos.")
    private String cpf;
    @NotNull
    @Size(min=2, max=100)
    private String nome;
    @NotNull
    private String email;
    @NotNull
    @Past
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;
    @NotNull
    private String senha;
    @NotNull
    private String telefone;
 
    public Pessoas() {}
 
    public Pessoas(String cpf, String nome, String email, LocalDate dataNascimento, String senha, String telefone ) {
         this.cpf = cpf;
         this.nome = nome;
         this.email = email;
         this.dataNascimento = dataNascimento;
         this.senha = senha;
         this.telefone = telefone;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "NOME",nullable = false)
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(name = "CPF", nullable = false, unique = true)
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
 
    @Column(name = "EMAIL", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name = "NASCIMENTO", nullable = false)
    public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	 @Column(name ="SENHA",nullable = false)
    public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Column(name = "TELEFONE",nullable = false)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
    public String toString() {
        return "Cadastro [id=" + id + ", Nome=" + nome + ", CPF=" + cpf + ", e-mail=" + email + ", data de nascimento=" + dataNascimento +", Senha="+ senha +", Telefone="+ telefone + "]";
    }
}
