package com.jeanpiress.conferidordejogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpiress.conferidordejogos.entities.Jogo;
import com.jeanpiress.conferidordejogos.repository.JogoRepository;

@Service
public class JogoService {
   

	@Autowired
	private JogoRepository repository;
    


	public List<Jogo> buscar(){
		return repository.findAll();
	}
	
	public Jogo buscarPorId(Long id) {
		Optional<Jogo> obj = repository.findById(id);
		return obj.get();
	}

	public Jogo inserir(Jogo jogo) {
		return repository.save(jogo);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
	public Jogo atualizar(Long id, Jogo jogo) {
		Jogo jogo2 = repository.getReferenceById(id);
		BeanUtils.copyProperties(jogo, jogo2, "id");
		 return repository.save(jogo2);
	}
}
