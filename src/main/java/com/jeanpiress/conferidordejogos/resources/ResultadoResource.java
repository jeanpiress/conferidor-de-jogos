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

import com.jeanpiress.conferidordejogos.entities.Resultado;
import com.jeanpiress.conferidordejogos.service.ResultadoService;

@RestController
@RequestMapping(value = "/resultados")
public class ResultadoResource {

	@Autowired
	private ResultadoService service;

	
	@GetMapping
	public ResponseEntity<List<Resultado>> buscar(){
		List<Resultado> r = service.buscar();
		return ResponseEntity.ok().body(r);
		
	}
	
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Resultado> buscarPorId(@PathVariable Long id){
			Resultado r = service.buscarPorId(id);
		return ResponseEntity.ok().body(r);
		
	}
	
	@GetMapping(value = "/concurso/{concurso}")
	public ResponseEntity<Resultado> buscarPorConcurso(@PathVariable Long concurso){
			Resultado r = service.buscarPorConsurso(concurso);
		return ResponseEntity.ok().body(r);
		
	}
	
	@PostMapping
	public ResponseEntity<Resultado> inserir(@Valid @RequestBody Resultado resultado){
		Resultado r = service.inserir(resultado);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(r.getId()).toUri();
		return ResponseEntity.created(uri).body(r);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Resultado> atualizar(@PathVariable Long id, @RequestBody Resultado resultado){
		Resultado resultado2 = service.atualizar(id, resultado);
		return ResponseEntity.ok().body(resultado2);
	}
		
}
