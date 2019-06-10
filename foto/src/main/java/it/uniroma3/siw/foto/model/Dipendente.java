package it.uniroma3.siw.foto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dipendente {	
	
	@Id
	private String email;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private String ruolo;
	
	//metodo public di getPassword, sara' necessario?
	@Column(nullable = false)
	private String password;
	
	public Dipendente() {
		
	}
	
	public Dipendente(String email, String password, String nome, String cognome, String ruolo) {
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		
	}
	
	public boolean checkPassword(String pwd) {
		return this.password==pwd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	/*
	public String getPassword() {
		return password;
	}
	*/
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
