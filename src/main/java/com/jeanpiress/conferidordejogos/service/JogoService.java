package com.jeanpiress.conferidordejogos.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
	
	public List<Jogo> buscarPorConcurso(Long concurso) {
		List<Jogo> obj = repository.findByNumeroConcurso(concurso);
		if(obj.size() == 0) {
			throw new EntityNotFoundException();
		}
		return obj;
		
	}
	
	public List<Jogo> buscarPorConcursoEUsuario(Long concurso, Long usuario) {
		
		List<Jogo> obj = repository.buscarPorNumeroConcursoAndUsuario(concurso, usuario);
		if(obj.size() == 0) {	
		throw new EntityNotFoundException();
		}
		return obj;
		
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