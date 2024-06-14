package com.marcos.livraria_sistemas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.livraria_sistemas.dto.GeneroCreateDto;
import com.marcos.livraria_sistemas.dto.GeneroResponseDto;
import com.marcos.livraria_sistemas.model.Genero;

public class GeneroMapper {

	public static GeneroResponseDto toDto(Genero genero) {
		return new ModelMapper().map(genero, GeneroResponseDto.class);
	}

	public static Genero toGenero(GeneroCreateDto dto) {
		return new ModelMapper().map(dto, Genero.class);
	}
	
	public static List<GeneroResponseDto> toListDto(List<Genero> genero){
		return genero.stream().map(gen -> toDto(gen)).collect(Collectors.toList());
	}
}
