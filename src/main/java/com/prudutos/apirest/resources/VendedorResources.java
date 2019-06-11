package com.prudutos.apirest.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import com.prudutos.apirest.models.Vendedor;
import com.prudutos.apirest.repository.VendedorRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class VendedorResources {
	@Autowired
	VendedorRepository vendedorRepository;
	
	@ApiOperation(value="Retorna uma lista de Vendedores")
	@GetMapping("/vendedores")
	public Iterable<Vendedor>  listaVendas(Pageable pageable){
		return   vendedorRepository.findAll(pageable);
	}
	
	@ApiOperation(value="Retorna um Vendedor unico")
	@GetMapping("/vendedor/{id}")
	public Vendedor listaVendaUnico(@PathVariable(value="id") long id){
		verifyIfVendedorExists(id);			
		return vendedorRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um Vendedor")
	@PostMapping("/vendedor")
	public Vendedor salvaVenda(@RequestBody @Valid Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	
	@ApiOperation(value="Deleta um Vendedor")
	@DeleteMapping("/vendedor")
	public void deletaVenda(@RequestBody @Valid Vendedor vendedor) {
		verifyIfVendedorExists(vendedor.getId());
		vendedorRepository.delete(vendedor);
	}
	
	@ApiOperation(value="Atualiza um Vendedor")
	@PutMapping("/vendedor")
	public Vendedor atualizaVenda(@RequestBody @Valid Vendedor vendedor) {
		verifyIfVendedorExists(vendedor.getId());
		return vendedorRepository.save(vendedor);
	}
	
	private void verifyIfVendedorExists(long id) {
		if(vendedorRepository.findById(id)==null) {
			throw new  ResourceNotFoundException("Vendedor not found for ID: "+id);
		}		
	}

}
