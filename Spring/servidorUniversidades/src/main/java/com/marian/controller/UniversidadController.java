package com.marian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marian.dto.Universidad;
import com.marian.repository.UniversidadRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UniversidadController {

	@Autowired
	private UniversidadRepository universidadRepositorio;

	@GetMapping("/universidad")
	public ResponseEntity<List<Universidad>> getUniversidades(){
		return new ResponseEntity<>(universidadRepositorio.getUniversidades(), HttpStatus.OK);
	}
	
	@PostMapping("/universidad")
	public ResponseEntity createUniversidad(@RequestBody final Universidad universidad){
		if(universidad != null && universidad.getNombre() != null && universidad.getLocalidad() != null) {
			universidadRepositorio.createUniversidad(universidad);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/universidad/{id}")
	public ResponseEntity deleteUniversidad(@PathVariable("id") final int id){
		boolean universidadBorrada = universidadRepositorio.deleteUniversidad(id);
		if(universidadBorrada) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}
