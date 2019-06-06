package com.prudutos.apirest.resources;

import java.util.List;

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
import com.prudutos.apirest.models.Produto;
import com.prudutos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResources {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@ApiOperation(value="Retorna uma lista de Produtos")
	@GetMapping("/produtos")
	public ResponseEntity<?>  listaProdutos(Pageable pageable){
		return new ResponseEntity<>( produtoRepository.findAll(pageable), HttpStatus.OK);
	}
	
	@ApiOperation(value="Retorna um produto unico")
	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		verifyIfProdutoExists(id);			
		return produtoRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um produto")
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@ApiOperation(value="Deleta um produto")
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody @Valid Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@ApiOperation(value="Atualiza um produto")
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}
	
	private void verifyIfProdutoExists(long id) {
		if(produtoRepository.findById(id)==null) {
			throw new  ResourceNotFoundException("Produto not found for ID: "+id);
		}
		
	}
	 

}