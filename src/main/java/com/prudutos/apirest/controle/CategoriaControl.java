package com.prudutos.apirest.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prudutos.apirest.errors.ResourceNotFoundException;
import com.prudutos.apirest.models.Categoria;
import com.prudutos.apirest.repository.CategoriaRepository;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;

@Service
public class CategoriaControl implements InterfaceControl<Categoria> {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public Categoria listar(long id) {
		verifyIfObjectExists(id);
		return categoriaRepository.findById(id); //categoriaRepository.findById(id);
	}

	@Override
	public Categoria salvar(Categoria t) {
		//t.setId(0);
		//System.out.println("imprimindo"+t.getId());
		return categoriaRepository.save(t);
	}

	@Override
	public void deletar(Categoria t) {
		verifyIfObjectExists(t.getId());
		categoriaRepository.delete(t);
	}
	
	public void deletarById(long id) {
		verifyIfObjectExists(id);
		categoriaRepository.deleteById(id);
	}

	@Override
	public Categoria atualizar(Categoria t) {
		verifyIfObjectExists(t.getId());
		return categoriaRepository.save(t);
	}

	@Override
	public Iterable<Categoria> listarTodos(Pageable pageable) {
		return categoriaRepository.findAll(pageable);
	}
	
	public Iterable<Categoria> listarTodosNormal(){
		return categoriaRepository.findAll();
	}
	
	@Override
	public void verifyIfObjectExists(long id) {
		if (categoriaRepository.findById(id) == null) {
			throw new ResourceNotFoundException("=( Categoria not found for ID: " + id);
		}
	}

}
