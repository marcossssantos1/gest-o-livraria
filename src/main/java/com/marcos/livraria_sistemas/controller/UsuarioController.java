package com.marcos.livraria_sistemas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.livraria_sistemas.dto.UsuarioCreateDto;
import com.marcos.livraria_sistemas.dto.UsuarioResponseDto;
import com.marcos.livraria_sistemas.mapper.UsuarioMapper;
import com.marcos.livraria_sistemas.model.Usuario;
import com.marcos.livraria_sistemas.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public ResponseEntity<UsuarioResponseDto> create(@RequestBody @Valid UsuarioCreateDto dto){
		Usuario usuario = UsuarioMapper.toUsuario(dto);
		service.create(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(usuario));
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioResponseDto> update(@Valid @PathVariable Long id, @Valid @RequestBody UsuarioCreateDto dto){
		Usuario usuario = UsuarioMapper.toUsuario(dto);
		usuario = service.update(id, usuario);
		usuario = service.findById(usuario.getId());
		return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toDto(usuario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDto> findById(@Valid @PathVariable Long id){
		Usuario usuario = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toDto(usuario));
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponseDto>> findAll(){
		List<Usuario> usuario = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toListDto(usuario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
}
