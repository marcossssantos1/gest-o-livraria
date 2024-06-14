package com.marcos.livraria_sistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.livraria_sistemas.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
