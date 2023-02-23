/*
package com.jeanpiress.conferidordejogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.entities.Aposta;
import com.jeanpiress.conferidordejogos.repository.ApostaRepository;

@Service
public class ApostaService {
   

	@Autowired
	private ApostaRepository repository;
    


	public List<Aposta> buscar(){
		return repository.findAll();
	}
	
	public Aposta buscarPorJogo(Long id) {
		Optional<Aposta> obj = repository.findById(id);
		return obj.get();
	}
}
*/