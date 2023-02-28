package com.jeanpiress.conferidordejogos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jeanpiress.conferidordejogos.entities.Jogo;
import com.jeanpiress.conferidordejogos.entities.Resultado;
import com.jeanpiress.conferidordejogos.entities.Usuario;
import com.jeanpiress.conferidordejogos.repository.JogoRepository;
import com.jeanpiress.conferidordejogos.repository.ResultadoRepository;
import com.jeanpiress.conferidordejogos.repository.UsuarioRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private JogoRepository jogoRepository;
	
	@Autowired
	private ResultadoRepository ResultadoRepository;
	
	@Override
	public void run(String... args) throws Exception {

          Usuario u1 = new Usuario(null, "Jean", "jean@gmail", "123");
          Usuario u2 = new Usuario(null, "Carol", "Carol@gmail", "1234");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		
	    
	     
	    Resultado r1 = new Resultado(null, 2320L, 1, 2, 3, 5, 7, 8, 9, 10, 13, 14, 16, 18, 20, 22, 23);
	    Resultado r2 = new Resultado(null, 2321L, 1, 2, 4, 5, 7, 8, 9, 10, 13, 16, 18, 20, 22, 24, 25);
	     
	   ResultadoRepository.saveAll(Arrays.asList(r1, r2));
	   
	   Jogo j1 = new Jogo(null, 2320L, 1, 2, 3, 5, 7, 8, 9, 10, 13, 14, 16, 18, 20, 22, 23, null, null, null, null, null, u2);	
	     Jogo j2 = new Jogo(null, 2320L, 1, 2, 4, 5, 7, 8, 9, 10, 13, 16, 18, 20, 22, 24, 25, null, null, null, null, null, u1);
	     Jogo j3 = new Jogo(null, 2320L, 1, 2, 5, 6, 7, 8, 10, 11, 12, 15, 16, 18, 20, 22, 24, 25, null, null, null, null, u1);
	     
	     
	     jogoRepository.saveAll(Arrays.asList(j1, j2, j3));
	  
	}
	
	
	
	
	
}
