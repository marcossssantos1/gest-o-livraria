package com.marcos.livraria_sistemas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.livraria_sistemas.dto.LivroCreateDto;
import com.marcos.livraria_sistemas.dto.LivroResponseDto;
import com.marcos.livraria_sistemas.model.Livro;

public class LivroMapper {

	public static LivroResponseDto toDto(Livro livro) {
		return new ModelMapper().map(livro, LivroResponseDto.class);
	}

	public static Livro toLivro(LivroCreateDto dto) {
		return new ModelMapper().map(dto, Livro.class);
	}
	
	public static List<LivroResponseDto> toListDto(List<Livro> livro){
		return livro.stream().map(livros -> toDto(livros)).collect(Collectors.toList());
	}
}
