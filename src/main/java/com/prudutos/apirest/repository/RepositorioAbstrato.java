package com.prudutos.apirest.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prudutos.apirest.models.AbstractModelo;

@NoRepositoryBean
public interface RepositorioAbstrato extends PagingAndSortingRepository<AbstractModelo, Long>{

	AbstractModelo findById(long id);
	//T FindById(long id);


}
