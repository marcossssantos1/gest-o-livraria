package com.marcos.livraria_sistemas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.livraria_sistemas.model.Livro;
import com.marcos.livraria_sistemas.repository.LivroRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro create(Livro livro) {
		return repository.save(livro);
	}

	public Livro findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Erro ao buscar livro com o id! "));
	}

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Void delete(Long id) {
		if (id != null) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Id inexistente na base dados");
		}
		return null;
	}

	public Livro update(Long id, Livro livro) {
		Livro livros = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Erro ao buscar livro com o id! "));
		livros.setNome(livro.getNome());
		livros.setIntroducao(livro.getIntroducao());
		livros.setNumeroPaginas(livro.getNumeroPaginas());
		return repository.save(livros);
	}

}
