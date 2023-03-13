package com.jeanpiress.conferidordejogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanpiress.conferidordejogos.entities.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{

	
	List<Jogo> findByNumeroConcurso(Long numeroConcurso);
	
}
