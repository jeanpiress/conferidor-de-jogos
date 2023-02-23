package com.jeanpiress.conferidordejogos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeanpiress.conferidordejogos.entities.Usuario;
import com.jeanpiress.conferidordejogos.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscar(){
		List<Usuario> u = service.buscar();
		return ResponseEntity.ok().body(u);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
			Usuario u = service.buscarPorId(id);
		return ResponseEntity.ok().body(u);
		
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario user){
		Usuario u = service.inserir(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(uri).body(u);
	}
}
