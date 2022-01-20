package com.processo.processoSeletivo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.processo.processoSeletivo.model.Fornecedor;
import com.processo.processoSeletivo.repository.FornecedorRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> getById(@PathVariable long id){
		return repository.findById(id).
				map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/fornecedor/{fornecedor}")
	public ResponseEntity<List<Fornecedor>> getByFornecedor (@PathVariable String fornecedor){
		return ResponseEntity.ok(repository.findAllByFornecedorContainingIgnoreCase(fornecedor));
		}
	
	@PostMapping
	public ResponseEntity<Fornecedor> post (@RequestBody Fornecedor fornecedor){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(fornecedor));
	}
	
	@PutMapping
	public ResponseEntity<Fornecedor> put (@RequestBody Fornecedor fornecedor){
		return ResponseEntity.ok(repository.save(fornecedor));
				
	}
	
	@DeleteMapping("/{id}")
	public void delet(@PathVariable long id) {
		repository.deleteById(id);
	}
}
