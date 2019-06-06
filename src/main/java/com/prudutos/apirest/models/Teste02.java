package com.prudutos.apirest.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_TESTE_02")
public class Teste02 extends AbstractEntity{
	
	private String campoTeste01;
	private String campoTeste02;
	private int campoTeste03;
	public String getCampoTeste01() {
		return campoTeste01;
	}
	public void setCampoTeste01(String campoTeste01) {
		this.campoTeste01 = campoTeste01;
	}
	public String getCampoTeste02() {
		return campoTeste02;
	}
	public void setCampoTeste02(String campoTeste02) {
		this.campoTeste02 = campoTeste02;
	}
	public int getCampoTeste03() {
		return campoTeste03;
	}
	public void setCampoTeste03(int campoTeste03) {
		this.campoTeste03 = campoTeste03;
	}
	

}
