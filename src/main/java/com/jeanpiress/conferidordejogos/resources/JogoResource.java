package com.jeanpiress.conferidordejogos.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Jogo> buscarPorId(@PathVariable Long id){
			Jogo u = service.buscarPorId(id);
		return ResponseEntity.ok().body(u);
		
	}
	
	@GetMapping(value = "/concurso/{concurso}")
	public ResponseEntity<List<Jogo>> buscarPorConcurso(@PathVariable Long concurso){
			List<Jogo> jogos = service.buscarPorConcurso(concurso);
		return ResponseEntity.ok().body(jogos);
		
	}
	
	@PostMapping
	public ResponseEntity<Jogo> inserir(@Valid @RequestBody Jogo jogo){
		Jogo j = service.inserir(jogo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(j.getId()).toUri();
		return ResponseEntity.created(uri).body(j);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Jogo> atualizar(@PathVariable Long id, @RequestBody Jogo jogo){
		Jogo jogo2 = service.atualizar(id, jogo);
		return ResponseEntity.ok().body(jogo2);
	}
		
}
