package com.prudutos.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.prudutos.apirest.models.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {
	Produto findById(long id);
	
}
