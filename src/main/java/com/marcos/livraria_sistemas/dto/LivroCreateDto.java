package com.marcos.livraria_sistemas.dto;

import com.marcos.livraria_sistemas.model.Genero;

import jakarta.validation.constraints.NotBlank;

public class LivroCreateDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String introducao;
	private int numeroPaginas;

	private Genero genero;

	public LivroCreateDto() {
	}

	public LivroCreateDto(@NotBlank String nome, @NotBlank String introducao, int numeroPaginas) {
		super();
		this.nome = nome;
		this.introducao = introducao;
		this.numeroPaginas = numeroPaginas;
	}

	public LivroCreateDto(@NotBlank String nome, @NotBlank String introducao, int numeroPaginas, Genero genero) {
		super();
		this.nome = nome;
		this.introducao = introducao;
		this.numeroPaginas = numeroPaginas;
		this.genero = genero;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
