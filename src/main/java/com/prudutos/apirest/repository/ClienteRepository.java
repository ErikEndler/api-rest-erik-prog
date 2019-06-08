package com.prudutos.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.prudutos.apirest.models.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>{
	Cliente findById(long id);
}
