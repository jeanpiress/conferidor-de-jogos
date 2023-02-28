package com.jeanpiress.conferidordejogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.entities.ResultadoFinal;
import com.jeanpiress.conferidordejogos.repository.ResultadoFinalRepository;

@Service
public class ResultadoFinalService {
   

	@Autowired
	private ResultadoFinalRepository repository;
	
	@Autowired
	private ResultadoService resultadoService;
	
	@Autowired
	private JogoService jogoService;
	


	public List<ResultadoFinal> buscar(){
		return repository.findAll();
	}
	
	
}