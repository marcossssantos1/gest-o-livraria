package com.marcos.livraria_sistemas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcos.livraria_sistemas.dto.GeneroCreateDto;
import com.marcos.livraria_sistemas.dto.GeneroResponseDto;
import com.marcos.livraria_sistemas.mapper.GeneroMapper;
import com.marcos.livraria_sistemas.model.Genero;
import com.marcos.livraria_sistemas.service.GeneroService;

import jakarta.validation.Valid;

@ControllerAdvice
@RequestMapping("api/v1/generos")
public class GeneroController {
	
	@Autowired
	private GeneroService service;
	
	@PostMapping
	public ResponseEntity<GeneroResponseDto> create(@RequestBody @Valid GeneroCreateDto dto){
		Genero genero = GeneroMapper.toGenero(dto);
		service.create(genero);
		return ResponseEntity.status(HttpStatus.CREATED).body(GeneroMapper.toDto(genero));
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<GeneroResponseDto> update(@Valid @PathVariable Long id, @Valid @RequestBody GeneroCreateDto dto){
		Genero gen = GeneroMapper.toGenero(dto);
		gen = service.update(id, gen);
		gen = service.findById(gen.getId());
		return ResponseEntity.status(HttpStatus.OK).body(GeneroMapper.toDto(gen));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GeneroResponseDto> findById(@Valid @PathVariable Long id){
		Genero genero = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(GeneroMapper.toDto(genero));
	}
	
	@GetMapping
	public ResponseEntity<List<GeneroResponseDto>> findAll(){
		List<Genero> genero = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(GeneroMapper.toListDto(genero));
	}
	
	@DeleteMapping("/{id]")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
}
