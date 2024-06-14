package com.marcos.livraria_sistemas.dto;

import jakarta.validation.constraints.NotBlank;

public class LivroResponseDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String introducao;
	private int numeroPaginas;

	public LivroResponseDto() {
	}

	public LivroResponseDto(@NotBlank String nome, @NotBlank String introducao, int numeroPaginas) {
		super();
		this.nome = nome;
		this.introducao = introducao;
		this.numeroPaginas = numeroPaginas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIntroducao() {
		return introducao;
	}

	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

}
