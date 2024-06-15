package com.marcos.livraria_sistemas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.livraria_sistemas.exceptions.CamposInvalidosException;
import com.marcos.livraria_sistemas.model.Usuario;
import com.marcos.livraria_sistemas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario create(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao buscar usuario com o id! "));
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Void delete(Long id) {
		if (id != null) {
			repository.deleteById(id);
		} else {
			throw new RuntimeException("Id inexistente na base dados");
		}
		return null;
	}

	public Usuario update(Long id, Usuario usuario) {
		Usuario usuarios = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Erro ao buscar usuario com o id! "));
		usuarios.setNome(usuario.getNome());
		usuarios.setEmail(usuario.getEmail());
		usuarios.setTelefone(usuario.getTelefone());
		usuarios.setSenha(usuario.getSenha());
		return repository.save(usuarios);
	}

}
