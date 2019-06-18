package com.prudutos.apirest.controle;

import org.springframework.stereotype.Service;

import com.prudutos.apirest.models.Vendedor;
import com.prudutos.apirest.repository.VendedorRepository;

@Service
public class VendedorControle extends ControleGeneric<Vendedor, VendedorRepository> {
	@Override
	protected String MenssagemErro() {
		String msg = "VENDEDOR";
		return msg;
	}

}
