package com.prudutos.apirest.resources;

import org.springframework.data.domain.Pageable;

public interface InterfaceResources<MODELO> {
	
	public Iterable<MODELO> listarTodosPagable(Pageable pageable);
	
	public Iterable<MODELO> listarTodos();
	
	public MODELO listar( long id);
	
	public MODELO salvar( MODELO modelo);
	
	public MODELO atualizar ( MODELO modelo);
	
	public void deletar( MODELO modelo);
	
	public void deleteById(long id);
	
	

}
