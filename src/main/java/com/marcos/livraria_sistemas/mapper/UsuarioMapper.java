package com.marcos.livraria_sistemas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.livraria_sistemas.dto.UsuarioCreateDto;
import com.marcos.livraria_sistemas.dto.UsuarioResponseDto;
import com.marcos.livraria_sistemas.model.Usuario;

public class UsuarioMapper {

	public static UsuarioResponseDto toDto(Usuario usuario) {
		return new ModelMapper().map(usuario, UsuarioResponseDto.class);
	}

	public static Usuario toUsuario(UsuarioCreateDto dto) {
		return new ModelMapper().map(dto, Usuario.class);
	}
	
	public static List<UsuarioResponseDto> toListDto(List<Usuario> usuario){
		return usuario.stream().map(gen -> toDto(gen)).collect(Collectors.toList());
	}
}
