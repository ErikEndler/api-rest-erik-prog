package com.prudutos.apirest.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import com.prudutos.apirest.errors.ResourceNotFoundException;
import com.prudutos.apirest.models.AbstractModelo;
import com.prudutos.apirest.repository.RepositorioAbstrato;


public abstract class ControleGeneric<MODELO extends AbstractModelo, REPOSITORIO extends RepositorioAbstrato> {

	protected String menssagem = "Objeto";
	@Autowired
	REPOSITORIO repository;
	
	public MODELO listar(long id) {
		verifyIfObjectExists(id);
		return (MODELO) repository.findById(id);
	}
	
	public MODELO salvar(MODELO modelo) {
		return repository.save(modelo);
	}

	public void deletar(MODELO modelo) {
		verifyIfObjectExists(modelo.getId());
		repository.delete(modelo);
	}
	
	public MODELO atualizar(MODELO modelo) {
		verifyIfObjectExists(modelo.getId());
		return repository.save(modelo);
	}
	
	public Iterable<MODELO> listarTodos(Pageable pageable) {	
		return (Iterable<MODELO>) repository.findAll(pageable);
	}

	private void verifyIfObjectExists(long id) {
		if (repository.findById(id) == null) {
			throw new ResourceNotFoundException(menssagem+" nao encontrado para o ID: " + id);
		}

	}

}
