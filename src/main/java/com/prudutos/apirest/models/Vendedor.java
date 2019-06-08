package com.prudutos.apirest.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_VENDEDOR")
public class Vendedor extends AbstractEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
