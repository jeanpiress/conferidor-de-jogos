package com.jeanpiress.conferidordejogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	public Usuario inserir(Usuario user) {
		user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		return repository.save(user);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
		}
	
	public Usuario atualizar(Long id, Usuario user) {
			Usuario user2 = repository.getReferenceById(id);
			BeanUtils.copyProperties(user, user2, "id");
			 return repository.save(user2);
		}
		
	}
	

