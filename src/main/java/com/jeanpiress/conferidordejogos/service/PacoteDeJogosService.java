package com.jeanpiress.conferidordejogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.entities.PacoteDeJogos;
import com.jeanpiress.conferidordejogos.repository.PacoteDeJogosRepository;

@Service
public class PacoteDeJogosService {
   

	@Autowired
	private PacoteDeJogosRepository repository;
    


	public List<PacoteDeJogos> buscar(){
		return repository.findAll();
	}
	
	public PacoteDeJogos buscarPorId(Long id) {
		Optional<PacoteDeJogos> obj = repository.findById(id);
		return obj.get();
	}
}
