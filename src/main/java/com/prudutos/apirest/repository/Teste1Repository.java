package com.prudutos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prudutos.apirest.models.Teste1;

public interface Teste1Repository extends JpaRepository<Teste1, Long>{
	Class<Teste1> findById(long id);

}
