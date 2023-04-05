package com.jeanpiress.conferidordejogos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.entities.Role;
import com.jeanpiress.conferidordejogos.entities.Usuario;
import com.jeanpiress.conferidordejogos.exceptionHandler.UsuarioRepetidoException;
import com.jeanpiress.conferidordejogos.repository.RoleRepository;
import com.jeanpiress.conferidordejogos.repository.UsuarioRepository;

@Service
public class UsuarioService {
   

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
    


	public List<Usuario> buscar(){
		return repository.findAll();
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}
	
	public Usuario inserir(Usuario user) {
		try {
		Optional<Role> roleUser = roleRepository.findById(2L);
		user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		List<Role> roles2 = user.getRoles();
		roles2.add(roleUser.get());
		user.setRoles(roles2);
		return repository.save(user);
		}catch(DataIntegrityViolationException e) {
			throw new UsuarioRepetidoException();
		}
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
		}
	
	public Usuario atualizar(Long id, Usuario user) {
			Usuario user2 = repository.getReferenceById(id);
			BeanUtils.copyProperties(user, user2, "id" , "senha");
			 return repository.save(user2);
		}
	
	public Usuario atualizarSenha(Long id, Usuario user) {
		Usuario user2 = repository.getReferenceById(id);
				user2.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		 return repository.save(user2);
	}
	
	public Usuario concederAdmin(Long id) {
		Usuario user = repository.getReferenceById(id);
		Optional<Role> roleAdmin = roleRepository.findById(1L);
		List<Role> roleAdminFinal = new ArrayList<>();
		roleAdminFinal.add(roleAdmin.get());
		user.setRoles(roleAdminFinal);
		 return repository.save(user);
	}
	
	public Usuario rebaixar(Long id) {
		Usuario user = repository.getReferenceById(id);
		Optional<Role> roleUser = roleRepository.findById(2L);
		List<Role> roleUserFinal = new ArrayList<>();
		roleUserFinal.add(roleUser.get());
		user.setRoles(roleUserFinal);
		 return repository.save(user);
	}
		
	}
	

