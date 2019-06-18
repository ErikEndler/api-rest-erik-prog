package com.prudutos.apirest.controle;

import org.springframework.stereotype.Service;

import com.prudutos.apirest.models.Categoria;
import com.prudutos.apirest.repository.CategoriaRepository;

@Service
public class CategoriaControl2 extends ControleGeneric<Categoria, CategoriaRepository> {

	@Override
	protected String MenssagemErro() {
		String msg = "CATEGORIA";
		return msg;
	}
}
