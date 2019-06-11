package com.prudutos.apirest.controle;

import org.springframework.data.domain.Pageable;

import com.prudutos.apirest.models.Categoria;

public interface InterfaceControl<T> {


	Iterable<T> listarTodos(Pageable pageable);

	T salvar(T t);

	void deletar(T t);

	T atualizar(T t);

	void verifyIfObjectExists(long id);

	Categoria listar(long id);

}
