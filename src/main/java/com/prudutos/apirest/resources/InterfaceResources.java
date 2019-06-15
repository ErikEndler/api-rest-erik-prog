package com.prudutos.apirest.resources;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface InterfaceResources<MODELO> {
	
	public Iterable<MODELO> listarTodosPagable(Pageable pageable);
	
	public Iterable<MODELO> listarTodos();
	
	public Optional<MODELO> listar( long id);
	
	public MODELO salvar( MODELO modelo);
	
	public MODELO atualizar ( MODELO modelo);
	
	public void deletar( MODELO modelo);
	
	public void deleteById( long id);
	
	

}
