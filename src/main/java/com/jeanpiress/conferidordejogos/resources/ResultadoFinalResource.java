package com.jeanpiress.conferidordejogos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeanpiress.conferidordejogos.entities.ResultadoFinal;
import com.jeanpiress.conferidordejogos.service.ResultadoFinalService;

@RestController
@RequestMapping(value = "/finais")
public class ResultadoFinalResource {

	@Autowired
	private ResultadoFinalService service;

	
	@GetMapping(value = "/{concurso}")
	public ResponseEntity<List<ResultadoFinal>> conferirConcurso(@PathVariable Long concurso){
		List<ResultadoFinal> r = service.conferirConcurso(concurso);
		return ResponseEntity.ok().body(r);
		
	}
	
	
	
		
}
