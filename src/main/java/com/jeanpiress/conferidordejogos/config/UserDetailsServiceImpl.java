package com.jeanpiress.conferidordejogos.config;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.entities.Usuario;
import com.jeanpiress.conferidordejogos.repository.UsuarioRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	public UsuarioRepository usuarioRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username).
				orElseThrow(() -> new EntityNotFoundException());
		return new User(usuario.getEmail(), usuario.getPassword(), usuario.getAuthorities());
	}

}
