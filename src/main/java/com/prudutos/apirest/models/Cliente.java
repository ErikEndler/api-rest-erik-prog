package com.prudutos.apirest.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_CLIENTE")
public class Cliente extends AbstractModelo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank
	private String nome;
	@NotBlank
	private String cpf;
	@NotBlank
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	

}
