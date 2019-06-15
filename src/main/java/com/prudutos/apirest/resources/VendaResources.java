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

import com.prudutos.apirest.controle.VendaControle;
import com.prudutos.apirest.errors.ResourceNotFoundException;
import com.prudutos.apirest.models.Venda;
import com.prudutos.apirest.repository.VendaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api/venda")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class VendaResources implements InterfaceResources<Venda> {
	
	@Autowired
	VendaControle vendaControle;

	@Override
	@ApiOperation(value="Retorna uma lista de vendas com pageable")
	@GetMapping("/pageable")
	public Iterable<Venda> listarTodosPagable(Pageable pageable) {		
		return vendaControle.listarTodos(pageable);
	}

	@Override
	@ApiOperation(value="Retorna uma lista de vendas")
	@GetMapping("")
	public Iterable<Venda> listarTodos() {
		// TODO Auto-generated method stub
		return vendaControle.listarTodosNormal();
	}

	@Override
	@ApiOperation(value="Retorna uma venda unico")
	@GetMapping("/{id}")
	public Optional<Venda> listar(@PathVariable(value="id") long id) {
		// TODO Auto-generated method stub
		return vendaControle.listar(id);
	}

	@Override
	@ApiOperation(value="Salva uma venda")
	@PostMapping("")
	public Venda salvar(@RequestBody @Valid Venda modelo) {
		// TODO Auto-generated method stub
		return vendaControle.salvar(modelo);
	}

	@Override
	@ApiOperation(value="Atualiza uma venda")
	@PutMapping("")
	public Venda atualizar(@RequestBody @Valid Venda modelo) {
		// TODO Auto-generated method stub
		return vendaControle.atualizar(modelo);
	}

	@Override
	@ApiOperation(value="Deleta uma venda (objeto)")
	@DeleteMapping("")
	public void deletar(@RequestBody @Valid Venda modelo) {
		vendaControle.deletar(modelo);			
	}

	@Override
	@ApiOperation(value="Deleta uma venda")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(value="id") long id) {
		vendaControle.deletarById(id);		
	}

}
