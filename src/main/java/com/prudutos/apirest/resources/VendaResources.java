package com.prudutos.apirest.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.prudutos.apirest.models.Venda;
import com.prudutos.apirest.repository.VendaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class VendaResources {
	
	@Autowired
	VendaRepository vendaRepository;
	
	@ApiOperation(value="Retorna uma lista de vendas")
	@GetMapping("/vendas")
	public List<Venda>  listaProdutos(){
		return  (List<Venda>) vendaRepository.findAll();
	}
	
	@ApiOperation(value="Retorna uma venda unico")
	@GetMapping("/venda/{id}")
	public Venda listaProdutoUnico(@PathVariable(value="id") long id){
		verifyIfProdutoExists(id);			
		return vendaRepository.findById(id);
	}
	
	@ApiOperation(value="Salva uma venda")
	@PostMapping("/venda")
	public Venda salvaProduto(@RequestBody @Valid Venda venda) {
		return vendaRepository.save(venda);
	}
	
	@ApiOperation(value="Deleta uma venda")
	@DeleteMapping("/venda")
	public void deletaProduto(@RequestBody @Valid Venda venda) {
		vendaRepository.delete(venda);
	}
	
	@ApiOperation(value="Atualiza uma venda")
	@PutMapping("/venda")
	public Venda atualizaProduto(@RequestBody @Valid Venda venda) {
		return vendaRepository.save(venda);
	}
	
	private void verifyIfProdutoExists(long id) {
		if(vendaRepository.findById(id)==null) {
			throw new  ResourceNotFoundException("Venda not found for ID: "+id);
		}
		
	}
	 


}
