package com.prudutos.apirest.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prudutos.apirest.errors.ResourceNotFoundException;
import com.prudutos.apirest.models.Categoria;
import com.prudutos.apirest.repository.CategoriaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class CategoriaResources {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@ApiOperation(value="Retorna uma lista de Categorias")
	@GetMapping("/categorias")
	public ResponseEntity<?>  listaCategorias(Pageable pageable){
		return new ResponseEntity<>( categoriaRepository.findAll(pageable), HttpStatus.OK);
	}
	
	@ApiOperation(value="Retorna uma categoria unica")
	@GetMapping("/categoria/{id}")
	public Categoria listaCategoriaUnica(@PathVariable(value="id") long id){
		verifyIfCategoriaExists(id);			
		return categoriaRepository.findById(id);
	}
	
	@ApiOperation(value="Salva uma categoria")
	@PostMapping("/categoria")
	public Categoria salvaCategoria(@RequestBody @Valid Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@ApiOperation(value="Deleta uma categoria")
	@DeleteMapping("/categoria")
	public void deletaCategoria(@RequestBody @Valid Categoria categoria) {
		categoriaRepository.delete(categoria);
	}
	
	@ApiOperation(value="Atualiza uma categoria")
	@PutMapping("/categoria")
	public Categoria atualizaCategoria(@RequestBody @Valid Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	private void verifyIfCategoriaExists(long id) {
		if(categoriaRepository.findById(id)==null) {
			throw new  ResourceNotFoundException("Categoria not found for ID: "+id);
		}
		
	}

}
