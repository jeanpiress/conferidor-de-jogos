package com.jeanpiress.conferidordejogos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jeanpiress.conferidordejogos.entities.Usuario;
import com.jeanpiress.conferidordejogos.repository.UsuarioRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {

          Usuario u1 = new Usuario(null, "Jean", "jean@gmail", "123");
          Usuario u2 = new Usuario(null, "Carol", "Carol@gmail", "1234");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
	
	
	
}
