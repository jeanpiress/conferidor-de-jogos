package com.jeanpiress.conferidordejogos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeanpiress.conferidordejogos.entities.Jogo;
import com.jeanpiress.conferidordejogos.service.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoResource {

	@Autowired
	private JogoService service;

	
	@GetMapping
	public ResponseEntity<List<Jogo>> buscar(){
		List<Jogo> u = service.buscar();
		return ResponseEntity.ok().body(u);
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Jogo> buscarPorId(@PathVariable Long id){
			Jogo u = service.buscarPorId(id);
		return ResponseEntity.ok().body(u);
		
	}
	
	
}
