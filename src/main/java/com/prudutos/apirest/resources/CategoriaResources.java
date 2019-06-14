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

import com.prudutos.apirest.controle.CategoriaControl;
import com.prudutos.apirest.models.Categoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class CategoriaResources implements InterfaceResources<Categoria> {

	@Autowired
	CategoriaControl controle = new CategoriaControl();

	@Override
	@ApiOperation(value = "Retorna uma lista de Categorias Com Pagable")
	@GetMapping("/categoriasPagable")
	public Iterable<Categoria> listarTodosPagable(Pageable pageable) {
		return controle.listarTodos(pageable);
	}

	@Override
	@ApiOperation(value = "Retorna uma lista de Categorias Normal")
	@GetMapping("/categorias")
	public Iterable<Categoria> listarTodos() {
		return controle.listarTodosNormal();
	}

	@Override
	@ApiOperation(value = "Retorna uma categoria unica")
	@GetMapping("/categoria/{id}")
	public Categoria listar(@PathVariable(value="id")long id) {		
		return controle.listar(id);
	}
	@ApiOperation(value = "Retorna uma categoria unica com ResponseEntity")
	@GetMapping("/categoriaRES/{id}")
	public ResponseEntity<Categoria> listarResponse(@PathVariable(value="id")long id){
		return new ResponseEntity<>(controle.listar(id), HttpStatus.OK);
		
	}

	@Override
	@ApiOperation(value = "Salva uma categoria")
	@PostMapping("/categoria")
	public Categoria salvar(@RequestBody @Valid Categoria categoria) {
		// TODO Auto-generated method stub
		return controle.salvar(categoria);
	}

	@Override
	@ApiOperation(value = "Atualiza uma categoria")
	@PutMapping("/categoria")
	public Categoria atualizar(@RequestBody @Valid Categoria categoria) {
		return controle.atualizar(categoria);
	}

	@Override
	@ApiOperation(value = "Deleta uma categoria por Objeto")
	@DeleteMapping("/categoria")
	public void deletar(@RequestBody @Valid Categoria categoria) {
		controle.deletar(categoria);
	}

	@Override
	@ApiOperation(value = "Deleta uma categoria por Id")
	@DeleteMapping("/categoriaById/{id}")
	public void deleteById(@PathVariable(value="id")long id) {
		controle.deletarById(id);
	}

	
	
	
	
	/*
	 * @ApiOperation(value = "Retorna uma lista de Categorias")
	 * 
	 * @GetMapping("/categorias") public Iterable<Categoria>
	 * listaCategorias(Pageable pageable) { return controle.listarTodos(pageable); }
	 * 
	 * @ApiOperation(value="Retorna uma categoria unica")
	 * 
	 * @GetMapping("/categoria/{id}") public Categoria
	 * listaCategoriaUnica(@PathVariable(value="id") Long id){
	 * //verifyIfCategoriaExists(id); return controle.listar(id); }
	 * 
	 * @ApiOperation(value="Salva uma categoria")
	 * 
	 * @PostMapping("/categoria") public Categoria
	 * salvaCategoria(@RequestBody @Valid Categoria categoria) { return
	 * controle.salvar(categoria); }
	 * 
	 * 
	 * @ApiOperation(value = "Deleta uma categoria")
	 * 
	 * @DeleteMapping("/categoria") public void deletaCategoria(@RequestBody @Valid
	 * Categoria categoria) { controle.deletar(categoria); }
	 * 
	 * @ApiOperation(value = "Atualiza uma categoria")
	 * 
	 * @PutMapping("/categoria") public Categoria
	 * atualizaCategoria(@RequestBody @Valid Categoria categoria) { return
	 * controle.atualizar(categoria); }
	 */

}
