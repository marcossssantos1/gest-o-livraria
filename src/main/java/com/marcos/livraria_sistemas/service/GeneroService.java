package com.marcos.livraria_sistemas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.livraria_sistemas.model.Genero;
import com.marcos.livraria_sistemas.repository.GeneroRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repository;

	public Genero create(Genero genero) {
		return repository.save(genero);
	}

	public Genero findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Erro ao buscar genero com o id! "));
	}

	public List<Genero> findAll() {
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

	public Genero update(Long id, Genero genero) {
		Genero gen = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Erro ao buscar genero com o id! "));
		gen.setNome(genero.getNome());
		return repository.save(gen);
	}

}
