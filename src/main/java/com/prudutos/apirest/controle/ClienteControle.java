package com.prudutos.apirest.controle;

import org.springframework.stereotype.Service;

import com.prudutos.apirest.models.Cliente;
import com.prudutos.apirest.repository.ClienteRepository;

@Service
public class ClienteControle extends ControleGeneric<Cliente, ClienteRepository> {
	@Override
	protected String MenssagemErro() {
		String msg = "CLIENTE";
		return msg;
	}

}
