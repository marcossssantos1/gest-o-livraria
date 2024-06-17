package com.marcos.livraria_sistemas.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(name = "nome")
	private String nome;
	@NotBlank
	@Column(name = "introducao")
	private String introducao;
	@Column(name = "numero-paginas", nullable = false)
	private int numeroPaginas;

	@ManyToOne
	@JoinColumn(name = "id_genero")
	private Genero genero;

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(Long id, @NotBlank String nome, @NotBlank String introducao, int numeroPaginas) {
		this.id = id;
		this.nome = nome;
		this.introducao = introducao;
		this.numeroPaginas = numeroPaginas;
	}

	public Livro(Long id, @NotBlank String nome, @NotBlank String introducao, int numeroPaginas, Genero genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.introducao = introducao;
		this.numeroPaginas = numeroPaginas;
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

}
