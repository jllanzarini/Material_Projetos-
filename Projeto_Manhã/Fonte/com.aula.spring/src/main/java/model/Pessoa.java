package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name ="Teste")
public class Pessoa {
	private Long id;
	private int idade;
	private String nome;
		
	public Pessoa() {
		
	}
	
	public Pessoa(int idade, String nome) {
		this.idade = idade;
		this.nome = nome;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    @Column(name = "idade",nullable = false)
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
    @Column(name = "nome",nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
