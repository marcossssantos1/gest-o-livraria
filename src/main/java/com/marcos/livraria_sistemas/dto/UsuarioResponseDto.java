package com.marcos.livraria_sistemas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioResponseDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String telefone;
	@NotBlank
	@Size(min = 6, max = 100, message = "Senha deve ter 6 até 100 caracteres para ser válida.")
	private String senha;

	public UsuarioResponseDto() {
	}

	public UsuarioResponseDto(@NotBlank String nome, @NotBlank String email, @NotBlank String telefone,
			@NotBlank @Size(min = 6, max = 100, message = "Senha deve ter 6 até 100 caracteres para ser válida.") String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
