package com.marcos.livraria_sistemas.dto;

import jakarta.validation.constraints.NotBlank;

public class GeneroResponseDto {

	@NotBlank
	private String nome;

	public GeneroResponseDto() {
	}

	public GeneroResponseDto(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
