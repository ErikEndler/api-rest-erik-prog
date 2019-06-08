package com.prudutos.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.prudutos.apirest.models.Vendedor;

public interface VendedorRepository extends PagingAndSortingRepository<Vendedor, Long>{
	Vendedor findById(long id);
}
