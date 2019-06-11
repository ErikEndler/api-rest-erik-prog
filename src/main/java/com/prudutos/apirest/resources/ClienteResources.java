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
import com.prudutos.apirest.models.Cliente;
import com.prudutos.apirest.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ClienteResources {
	@Autowired
	ClienteRepository clienteRepository;

	@ApiOperation(value = "Retorna uma lista de clientes")
	@GetMapping("/cliente")
	public ResponseEntity<?> listaClientes(Pageable pageable) {
		return new ResponseEntity<>(clienteRepository.findAll(pageable), HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna um cliente unico")
	@GetMapping("/cliente/{id}")
	public Cliente listaClienteUnico(@PathVariable(value = "id") long id) {
		verifyIfClienteExists(id);
		return clienteRepository.findById(id);
	}

	@ApiOperation(value = "Salva um cliente")
	@PostMapping("/cliente")
	public Cliente salvaCliente(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@ApiOperation(value = "Deleta um cliente")
	@DeleteMapping("/cliente")
	public void deletaCliente(@RequestBody @Valid Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	@ApiOperation(value = "Atualiza um cliente")
	@PutMapping("/cliente")
	public Cliente atualizaCliente(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	private void verifyIfClienteExists(long id) {
		if (clienteRepository.findById(id) == null) {
			throw new ResourceNotFoundException("Cliente not found for ID: " + id);
		}

	}

}
