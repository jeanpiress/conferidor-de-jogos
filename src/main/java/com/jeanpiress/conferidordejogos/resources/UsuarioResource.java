package com.jeanpiress.conferidordejogos.resources;

import java.net.URI;
import java.util.List;

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

import com.jeanpiress.conferidordejogos.entities.Usuario;
import com.jeanpiress.conferidordejogos.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<Usuario>> buscar(){
		List<Usuario> u = service.buscar();
		return ResponseEntity.ok().body(u);
		
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
			Usuario u = service.buscarPorId(id);
		return ResponseEntity.ok().body(u);
		
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@Valid @RequestBody Usuario user){
		Usuario u = service.inserir(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(uri).body(u);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario user){
		Usuario user2 = service.atualizar(id, user);
		return ResponseEntity.ok().body(user2);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/senha/{id}")
	public ResponseEntity<Usuario> atualizarSenha(@PathVariable Long id, @RequestBody Usuario user){
		Usuario user2 = service.atualizarSenha(id, user);
		return ResponseEntity.ok().body(user2);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/admin/{id}")
	public ResponseEntity<Usuario> concederAdmin(@PathVariable Long id){
		Usuario user2 = service.concederAdmin(id);
		return ResponseEntity.ok().body(user2);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/rebaixar/{id}")
	public ResponseEntity<Usuario> rebaixar(@PathVariable Long id){
		Usuario user2 = service.rebaixar(id);
		return ResponseEntity.ok().body(user2);
	}
}
