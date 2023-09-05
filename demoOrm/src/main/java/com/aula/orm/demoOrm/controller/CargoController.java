package com.aula.orm.demoOrm.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula.orm.demoOrm.model.Cargo;
import com.aula.orm.demoOrm.repository.CargoRepository;



@RestController
@RequestMapping({"/cargos"} )

public class CargoController {
private CargoRepository repository;
	
	CargoController(CargoRepository cargoRepository){
		this.repository = cargoRepository;
	}
	
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path= {"/{id}"})
	public ResponseEntity findById(@PathVariable long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
				
	}
	
	@PostMapping
	public Cargo create(@RequestBody Cargo cargo) {
		return repository.save(cargo);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Cargo cargo) {
		
		return repository.findById(id)
				.map(record -> {
					record.setNome(cargo.getNome());
					record.setDepartamento(cargo.getDepartamento());
					record.setFuncionarios(cargo.getFuncionarios());
					
					Cargo update = repository.save(record);
					return ResponseEntity.ok().body(update);
					
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity <?> delete(@PathVariable("id") long id){
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
		return ResponseEntity.ok().build();
	}).orElse(ResponseEntity.notFound().build());
		
	}
}
