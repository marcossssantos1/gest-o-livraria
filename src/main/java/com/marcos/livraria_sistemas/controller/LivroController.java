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

import com.marcos.livraria_sistemas.dto.LivroCreateDto;
import com.marcos.livraria_sistemas.dto.LivroResponseDto;
import com.marcos.livraria_sistemas.mapper.LivroMapper;
import com.marcos.livraria_sistemas.model.Livro;
import com.marcos.livraria_sistemas.service.LivroService;

import jakarta.validation.Valid;

@ControllerAdvice
@RequestMapping("api/v1/livros")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@PostMapping
	public ResponseEntity<LivroResponseDto> create(@RequestBody @Valid LivroCreateDto dto){
		Livro livro = LivroMapper.toLivro(dto);
		service.create(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(LivroMapper.toDto(livro));
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<LivroResponseDto> update(@Valid @PathVariable Long id, @Valid @RequestBody LivroCreateDto dto){
		Livro livro = LivroMapper.toLivro(dto);
		livro = service.update(id, livro);
		livro = service.findById(livro.getId());
		return ResponseEntity.status(HttpStatus.OK).body(LivroMapper.toDto(livro));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroResponseDto> findById(@Valid @PathVariable Long id){
		Livro livro = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(LivroMapper.toDto(livro));
	}
	
	@GetMapping
	public ResponseEntity<List<LivroResponseDto>> findAll(){
		List<Livro> livro = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(LivroMapper.toListDto(livro));
	}
	
	@DeleteMapping("/{id]")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
}
