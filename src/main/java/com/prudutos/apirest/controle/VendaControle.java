package com.prudutos.apirest.controle;

import org.springframework.stereotype.Service;

import com.prudutos.apirest.models.Venda;
import com.prudutos.apirest.repository.VendaRepository;

@Service
public class VendaControle extends ControleGeneric<Venda, VendaRepository>{
	@Override
	protected String MenssagemErro() {
		String msg = "VENDAs";
		return msg;
	}

}
