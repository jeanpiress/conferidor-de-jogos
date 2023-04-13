package com.jeanpiress.conferidordejogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jeanpiress.conferidordejogos.entities.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{

		
	List<Jogo> findByNumeroConcurso(Long numeroConcurso);
	
	@Query("select j from Jogo j where j.numeroConcurso = :numeroConcurso and j.usuario.id = :usuario")
	List<Jogo> buscarPorNumeroConcursoAndUsuario(Long numeroConcurso, Long usuario);
	
	
	
}
