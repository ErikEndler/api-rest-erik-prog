package com.prudutos.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.prudutos.apirest.models.Venda;

public interface VendaRepository extends PagingAndSortingRepository<Venda, Long>{
	Venda findById(long id);

}
