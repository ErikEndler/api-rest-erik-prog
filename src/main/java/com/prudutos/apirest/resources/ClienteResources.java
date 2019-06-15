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

import com.prudutos.apirest.controle.ClienteControle;
import com.prudutos.apirest.models.Cliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/cliente")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ClienteResources implements InterfaceResources<Cliente> {
	
	@Autowired
	ClienteControle clienteControle = new ClienteControle();
	

	@Override
	@ApiOperation(value = "Retorna uma lista de clientes com Pageable")
	@GetMapping("/Pageable")
	public Iterable<Cliente> listarTodosPagable(Pageable pageable) {		
		return clienteControle.listarTodos(pageable);
	}

	@Override
	@ApiOperation(value = "Retorna uma lista de clientes")
	@GetMapping("")
	public Iterable<Cliente> listarTodos() {		
		return clienteControle.listarTodosNormal();
	}

	@Override
	@ApiOperation(value = "Retorna um unico cliente ")
	@GetMapping("/{id}")
	public Optional<Cliente> listar(@PathVariable(value="id") long id) {		
		return clienteControle.listar(id);
	}

	@Override
	@ApiOperation(value = "Salva um cliente")
	@PostMapping("")
	public Cliente salvar(@RequestBody @Valid Cliente modelo) {
		return clienteControle.salvar(modelo);
	}

	@Override
	@ApiOperation(value = "Atualiza um cliente")
	@PutMapping("")
	public Cliente atualizar(@RequestBody @Valid Cliente modelo) {		
		return clienteControle.atualizar(modelo);
	}

	@Override
	@ApiOperation(value = "Deleta um cliente via Objeto")
	@DeleteMapping("")
	public void deletar(@RequestBody @Valid Cliente modelo) {		
		clienteControle.deletar(modelo);
		
	}

	@Override
	@ApiOperation(value = "Deleta um cliente via Objeto")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(value="id") long id) {
		clienteControle.deletarById(id);
	}

}
