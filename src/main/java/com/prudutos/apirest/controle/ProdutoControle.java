package com.prudutos.apirest.controle;

import org.springframework.stereotype.Service;

import com.prudutos.apirest.models.Produto;
import com.prudutos.apirest.repository.ProdutoRepository;

@Service
public class ProdutoControle extends ControleGeneric<Produto, ProdutoRepository> {
	@Override
	protected String MenssagemErro() {
		String msg = "PRODUTO";
		return msg;
	}
}
