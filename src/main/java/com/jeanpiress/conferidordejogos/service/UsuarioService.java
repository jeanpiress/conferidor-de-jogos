package com.jeanpiress.conferidordejogos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.entities.Usuario;
import com.jeanpiress.conferidordejogos.repository.UsuarioRepository;

@Service
public class UsuarioService {
   

	@Autowired
	private UsuarioRepository usuarioRepository;
    


	public List<Usuario> buscar(){
		return usuarioRepository.findAll();
	}
}
