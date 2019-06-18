package com.prudutos.apirest.resources;

import java.util.Optional;

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

import com.prudutos.apirest.controle.ProdutoControle;
import com.prudutos.apirest.models.Produto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api/produto")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResources implements InterfaceResources<Produto> {
	
	@Autowired
	ProdutoControle produtoControle;

	@Override
	@ApiOperation(value="Retorna uma lista de Produtos com Pageable")
	@GetMapping("/pageable")
	public Iterable<Produto> listarTodosPagable(Pageable pageable) {
		return produtoControle.listarTodos(pageable);
	}
	
	@Override
	@ApiOperation(value="Retorna uma lista de Produtos")
	@GetMapping("")
	public Iterable<Produto> listarTodos() {	
		return produtoControle.listarTodosNormal();
	}

	@Override
	@ApiOperation(value="Retorna um produto unico")
	@GetMapping("/{id}")
	public Optional<Produto> listar(@PathVariable(value="id") long id) {		
		return produtoControle.listar(id);
	}

	@Override
	@ApiOperation(value="Salva um produto")
	@PostMapping("")
	public Produto salvar(@RequestBody @Valid Produto modelo) {		
		return produtoControle.salvar(modelo);
	}

	@Override
	@ApiOperation(value="Atualiza um produto")
	@PutMapping("")
	public Produto atualizar(@RequestBody @Valid Produto modelo) {		
		return produtoControle.atualizar(modelo);
	}

	@Override
	@ApiOperation(value="Deleta um produto (objeto)")
	@DeleteMapping("")
	public void deletar(@RequestBody @Valid Produto modelo) {
		produtoControle.deletar(modelo);		
	}

	@Override
	@ApiOperation(value="Deleta um produto por id")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(value="id") long id) {
		produtoControle.deletarById(id);		
	}
	 

}