
package com.prudutos.apirest.controle;

import java.util.Optional;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prudutos.apirest.errors.ResourceNotFoundException;
import com.prudutos.apirest.models.AbstractModelo;

@MappedSuperclass
public abstract class ControleGeneric<MODELO extends AbstractModelo, REPOSITORIO extends PagingAndSortingRepository<MODELO, Long>> {

	@Autowired
	REPOSITORIO repository;

	public Optional<MODELO> listar(long id) {
		verifyIfObjectExists(id);
		Optional<MODELO> findById = repository.findById(id);
		return findById;
	}

	public MODELO salvar(MODELO modelo) {
		Optional<MODELO> ret = verifySave(modelo.getId());
		if (ret.isPresent()) {
			throw new ResourceNotFoundException(MenssagemErro() + " existente para o  ID: " + modelo.getId());

		} else
			return (MODELO) repository.save(modelo);
	}

	public void deletar(MODELO modelo) {
		// verifyIfObjectExists(modelo.getId());
		repository.delete(modelo);
	}

	public MODELO atualizar(MODELO modelo) {
		// verifyIfObjectExists(modelo.getId());
		return (MODELO) repository.save(modelo);
	}

	public Iterable<MODELO> listarTodos(Pageable pageable) {
		return (Iterable<MODELO>) repository.findAll(pageable);
	}

	public Iterable<MODELO> listarTodosNormal() {
		return (Iterable<MODELO>) repository.findAll();
	}

	public void deletarById(long id) {
		verifyIfObjectExists(id);
		repository.deleteById(id);
	}

	private void verifyIfObjectExists(long id) {
		String msg = MenssagemErro();
		Optional<MODELO> retorno = repository.findById(id);
		retorno.orElseThrow(() -> new ResourceNotFoundException(msg + " nao encontrado para o ID: " + id));
	}

	private Optional<MODELO> verifySave(long id) {
		Optional<MODELO> retorno = repository.findById(id);
		return retorno;

	}

	protected String MenssagemErro() {
		String msg = "Objeto";
		return msg;
	}

}
