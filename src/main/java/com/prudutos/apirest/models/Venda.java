package com.prudutos.apirest.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_VENDA")
public class Venda extends AbstractEntity {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private String data;
	
	private String Obs;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	private Vendedor vendedor;
	
	@ManyToOne
	private Cliente cliente;


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObs() {
		return Obs;
	}

	public void setObs(String obs) {
		Obs = obs;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}
