package com.jeanpiress.conferidordejogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanpiress.conferidordejogos.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
