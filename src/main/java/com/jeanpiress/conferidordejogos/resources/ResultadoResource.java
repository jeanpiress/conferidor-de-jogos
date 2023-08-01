package com.jeanpiress.conferidordejogos.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeanpiress.conferidordejogos.dto.Constancia;
import com.jeanpiress.conferidordejogos.dto.ResultadoRecebidoDTO;
import com.jeanpiress.conferidordejogos.dto.ResultadosDTO;
import com.jeanpiress.conferidordejogos.entities.Resultado;
import com.jeanpiress.conferidordejogos.entities.ResultadoApi;
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
	
	@GetMapping(value = "/ultimosResultados")
	public ResponseEntity<List<ResultadosDTO>> ultimosResultados(){
		List<ResultadosDTO> menuList = service.ultimosResultados();
		menuList = service.ordenarListaResultado(menuList);
		
		return ResponseEntity.ok().body(menuList);
		
	}
	
	@GetMapping(value = "/constancia")
	public ResponseEntity<Constancia> constancia4() throws Exception{
		Constancia menuDto = service.constancia4();
		
		return ResponseEntity.ok().body(menuDto);
		
	}
	
	@GetMapping(value = "/constancia3")
	public ResponseEntity<Constancia> constancia3(){
		Constancia menuDto = service.constancia3();
		
		return ResponseEntity.ok().body(menuDto);
		
	}
	
	
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Resultado> buscarPorId(@PathVariable Long id){
			Resultado r = service.buscarPorId(id);
		return ResponseEntity.ok().body(r);
		
	}
	
	@GetMapping(value = "/concurso/{concurso}")
	public ResponseEntity<ResultadosDTO> buscarPorConcurso(@PathVariable Long concurso){
			Resultado r = service.buscarPorConsurso(concurso);
			ResultadosDTO resultadoDTO = new ResultadosDTO(r);
		return ResponseEntity.ok().body(resultadoDTO);
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Resultado> inserir(@Valid @RequestBody ResultadoRecebidoDTO resultadoRecebido){
		Resultado recebido = service.converterResultado(resultadoRecebido);
		Resultado r = service.inserir(recebido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(r.getId()).toUri();
		return ResponseEntity.created(uri).body(r);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Resultado> atualizar(@PathVariable Long id, @RequestBody Resultado resultado){
		Resultado resultado2 = service.atualizar(id, resultado);
		return ResponseEntity.ok().body(resultado2);
	}
		
}
