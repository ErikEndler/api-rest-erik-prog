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

import com.prudutos.apirest.controle.CategoriaControl2;
import com.prudutos.apirest.models.Categoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/categoria")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class CategoriaResources implements InterfaceResources<Categoria> {

	@Autowired
	CategoriaControl2 controle = new CategoriaControl2();

	@Override
	@ApiOperation(value = "Retorna uma lista de Categorias Com Pagable")
	@GetMapping("/Pagable")
	public Iterable<Categoria> listarTodosPagable(Pageable pageable) {
		return controle.listarTodos(pageable);
	}

	@Override
	@ApiOperation(value = "Retorna uma lista de Categorias Normal")
	@GetMapping("")
	public Iterable<Categoria> listarTodos() {
		return controle.listarTodosNormal();
	}

	@Override
	@ApiOperation(value = "Retorna uma categoria unica")
	@GetMapping("/{id}")
	public Optional<Categoria> listar(@PathVariable(value="id")long id) {		
		return controle.listar(id);
	}

	@Override
	@ApiOperation(value = "Salva uma categoria")
	@PostMapping("")
	public Categoria salvar(@RequestBody @Valid Categoria categoria) {
		// TODO Auto-generated method stub
		return controle.salvar(categoria);
	}

	@Override
	@ApiOperation(value = "Atualiza uma categoria")
	@PutMapping("")
	public Categoria atualizar(@RequestBody @Valid Categoria categoria) {
		return controle.atualizar(categoria);
	}

	@Override
	@ApiOperation(value = "Deleta uma categoria por envio e um Objeto")
	@DeleteMapping("")
	public void deletar(@RequestBody @Valid Categoria categoria) {
		controle.deletar(categoria);
	}

	@Override
	@ApiOperation(value = "Deleta uma categoria por Id")
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable(value="id")long id) {
		controle.deletarById(id);
	}
}
