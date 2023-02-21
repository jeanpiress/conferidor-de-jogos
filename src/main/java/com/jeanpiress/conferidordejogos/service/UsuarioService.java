package com.jeanpiress.conferidordejogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.entities.Usuario;
import com.jeanpiress.conferidordejogos.repository.UsuarioRepository;

@Service
public class UsuarioService {
   

	@Autowired
	private UsuarioRepository repository;
    


	public List<Usuario> buscar(){
		return repository.findAll();
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}
}
