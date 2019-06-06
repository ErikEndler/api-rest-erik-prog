package com.prudutos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prudutos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Produto findById(long id);
	
}
