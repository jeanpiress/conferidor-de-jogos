package com.jeanpiress.conferidordejogos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeanpiress.conferidordejogos.entities.PacoteDeJogos;
import com.jeanpiress.conferidordejogos.service.PacoteDeJogosService;

@RestController
@RequestMapping(value = "/pacotes")
public class PacoteDeJogosResource {

	@Autowired
	private PacoteDeJogosService service;

	
	@GetMapping
	public ResponseEntity<List<PacoteDeJogos>> buscar(){
		List<PacoteDeJogos> u = service.buscar();
		return ResponseEntity.ok().body(u);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PacoteDeJogos> buscarPorId(@PathVariable Long id){
			PacoteDeJogos u = service.buscarPorId(id);
		return ResponseEntity.ok().body(u);
		
	}
}
