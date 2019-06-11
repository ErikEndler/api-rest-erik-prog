package com.prudutos.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.prudutos.apirest.models.Categoria;

public interface CategoriaRepository  extends PagingAndSortingRepository<Categoria, Long> {
	Categoria findById(long id);
	

}
