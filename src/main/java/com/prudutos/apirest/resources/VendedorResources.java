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

import com.prudutos.apirest.controle.VendedorControle;
import com.prudutos.apirest.models.Vendedor;
import com.prudutos.apirest.repository.VendedorRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api/vendedor")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class VendedorResources implements InterfaceResources<Vendedor> {
	@Autowired
	VendedorControle vendedoControle;			

	@Override
	@ApiOperation(value="Retorna uma lista de Vendedores com Pageable")
	@GetMapping("/pageable")
	public Iterable<Vendedor> listarTodosPagable(Pageable pageable) {
		return vendedoControle.listarTodos(pageable);
	}

	@Override
	@ApiOperation(value="Retorna uma lista de Vendedores")
	@GetMapping("")
	public Iterable<Vendedor> listarTodos() {
		return vendedoControle.listarTodosNormal();
	}

	@Override
	@ApiOperation(value="Retorna um Vendedor unico")
	@GetMapping("/{id}")
	public Optional<Vendedor> listar(@PathVariable(value="id") long id) {
		return vendedoControle.listar(id);
	}

	@Override
	@ApiOperation(value="Salva um Vendedor")
	@PostMapping("")
	public Vendedor salvar(@RequestBody @Valid Vendedor modelo) {
		// TODO Auto-generated method stub
		return vendedoControle.salvar(modelo);
	}

	@Override
	@ApiOperation(value="Atualiza um Vendedor")
	@PutMapping("")
	public Vendedor atualizar(@RequestBody @Valid Vendedor modelo) {
		// TODO Auto-generated method stub
		return vendedoControle.atualizar(modelo);
	}

	@Override
	@ApiOperation(value="Deleta um Vendedor (objeto)")
	@DeleteMapping("")
	public void deletar(@RequestBody @Valid Vendedor modelo) {		
		vendedoControle.deletar(modelo);		
	}

	@Override
	@ApiOperation(value="Deleta um Vendedor por ID")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(value="id") long id) {
		vendedoControle.deletarById(id);		
	}

}
