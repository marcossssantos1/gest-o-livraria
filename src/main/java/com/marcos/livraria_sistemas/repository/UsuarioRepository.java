package com.marcos.livraria_sistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.livraria_sistemas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
